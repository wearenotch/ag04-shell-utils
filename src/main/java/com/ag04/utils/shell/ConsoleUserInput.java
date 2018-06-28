package com.ag04.utils.shell;

import org.jline.reader.LineReader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author domagoj on 19.06.2018
 */
@Component
public class ConsoleUserInput {

    private LineReader lineReader;

    public ConsoleUserInput(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    /**
     * Loops until one of the `options` is provided. Pressing return is equivalent to
     * returning `defaultValue`.
     */
    public String promptWithOptions(String  prompt, String defaultValue, List<String> optionsAsList) {
        String answer;
        do {
            answer = lineReader.readLine(String.format("%s %s: ", prompt, optionsAsList));
        } while (!optionsAsList.contains(answer) && "" != answer);

        if (StringUtils.isEmpty(answer) && optionsAsList.contains("")) {
            return defaultValue;
        }
        return answer;
    }

    public String prompt(String  prompt, String defaultValue, boolean echo) {
        String answer = "";
        if (echo) {
            answer = lineReader.readLine("$prompt: ");
        } else {
            answer = lineReader.readLine("$prompt: ", '*');
        }
        if (StringUtils.isEmpty(answer)) {
            return defaultValue;
        }
        return answer;
    }
}
