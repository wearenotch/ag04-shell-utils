package com.ag04.utils.shell;

import org.jline.reader.LineReader;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author domagoj on 01.08.2018
 */
public class ShellHelper {

    public static final List<String> DEFAULT_CONFIRM_WORDS = Arrays.asList("y", "yes");

    private final List<String> confirmWords;

    private LineReader lineReader;

    public ShellHelper(LineReader lineReader) {
        this(lineReader, null);
    }

    public ShellHelper(LineReader lineReader, List<String> confirmWords) {
        this.confirmWords = confirmWords != null ? confirmWords : DEFAULT_CONFIRM_WORDS;
        this.lineReader = lineReader;
    }

    //--- prompt methods ------------------------------------------------------

    /**
     * Loops until one of the `options` is provided. Pressing return is equivalent to
     * returning `defaultValue`.
     */
    public String promptWithOptions(String  prompt, String defaultValue, List<String> optionsAsList) {
        String answer;
        List<String> allowedAnswers = new ArrayList<>(optionsAsList);
        if (StringUtils.hasText(defaultValue)) {
            allowedAnswers.add("");
        }
        do {
            answer = lineReader.readLine(String.format("%s %s: ", prompt, optionsAsList));
        } while (!allowedAnswers.contains(answer) && "" != answer);

        if (StringUtils.isEmpty(answer) && allowedAnswers.contains("")) {
            return defaultValue;
        }
        return answer;
    }

    /**
     * Loops until one of the `options` is provided.
     */
    public String promptWithOptions(String  prompt, List<String> optionsAsList) {
        return promptWithOptions(prompt, null, optionsAsList);
    }

    public String prompt(String  prompt, String defaultValue, boolean echo) {
        String answer = "";

        if (echo) {
            answer = lineReader.readLine(prompt + ": ");
        } else {
            answer = lineReader.readLine(prompt + ": ", '*');
        }
        if (StringUtils.isEmpty(answer)) {
            return defaultValue;
        }
        return answer;
    }

    //--- selectFromList methods ----------------------------------------------

    public String selectFromList(String promptMessage, Map<String, String> options, boolean ignoreCase, String defaultValue) {
        String answer;
        Set<String> allowedAnswers = new HashSet<>(options.keySet());
        if (defaultValue != null && !defaultValue.equals("")) {
            allowedAnswers.add("");
        }

        do {
            for (Map.Entry<String, String> option: options.entrySet()) {
                String defaultMarker = null;
                if (defaultValue != null) {
                    if (option.getKey().equals(defaultValue)) {
                        defaultMarker = "*";
                    }
                }
                if (defaultMarker != null) {
                    printInfo(String.format("%s [%s] %s ", defaultMarker, option.getKey(), option.getValue()));
                } else {
                    print(String.format("  hep[%s] %s", option.getKey(), option.getValue()));
                }
            }
            answer = lineReader.readLine(String.format("%s: ", promptMessage));
        } while (!containsString(allowedAnswers, answer, ignoreCase) && "" != answer);

        if (StringUtils.isEmpty(answer) && allowedAnswers.contains("")) {
            return defaultValue;
        }
        return answer;
    }

    public boolean containsString(Set <String> l, String s, boolean ignoreCase){
        if (!ignoreCase) {
            return l.contains(s);
        }

        Iterator <String> it = l.iterator();
        while(it.hasNext()) {
            if(it.next().equalsIgnoreCase(s))
                return true;
        }
        return false;
    }

    //--- print methods -------------------------------------------------------

    /**
     * Print message with color {@link PromptColor#GREEN}
     *
     * @param message message to print
     */
    public void printSuccess(String message) {
        print(message, PromptColor.GREEN);
    }

    /**
     * Print message with color {@link PromptColor#CYAN}
     *
     * @param message message to print
     */
    public void printInfo(String message) {
        print(message, PromptColor.CYAN);
    }

    /**
     * Print message with color {@link PromptColor#YELLOW}
     *
     * @param message message to print
     */
    public void printWarning(String message) {
        print(message, PromptColor.YELLOW);
    }

    /**
     * Print message with color {@link PromptColor#RED}
     *
     * @param message message to print
     */
    public void printError(String message) {
        print(message, PromptColor.RED);
    }

    /**
     * Print in the console
     *
     * @param message message to print
     */
    public void print(String message) {
        print(message, null);
    }

    /**
     * Print in the console
     *
     * @param message message to print
     * @param color   (optional) prompt color
     */
    public void print(String message, PromptColor color) {
        String toPrint = message;
        if (color != null) {
            toPrint = getColored(message, color);
        }
        lineReader.getTerminal().writer().println(toPrint);
    }

    /**
     * Color message with given color
     *
     * @param message message to return
     * @param color   color to print
     * @return colored message
     */
    public String getColored(String message, PromptColor color) {
        return new AttributedStringBuilder().append(
            message,
            AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())
        ).toAnsi();
    }

}
