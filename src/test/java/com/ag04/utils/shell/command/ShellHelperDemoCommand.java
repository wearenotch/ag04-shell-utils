package com.ag04.utils.shell.command;

import com.ag04.utils.shell.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author domagoj on 01.08.2018
 */
@ShellComponent
public class ShellHelperDemoCommand {

    @Autowired
    private ShellHelper shellHelper;

    @ShellMethod(value = "Print text in colors")
    public void printInColors() {
        shellHelper.println("Text in WHITE", PromptColor.WHITE);
        shellHelper.println("Text in BLACK", PromptColor.BLACK);
        shellHelper.println("Text in BLUE", PromptColor.BLUE);
        shellHelper.println("Text in BRIGHT", PromptColor.BRIGHT);
        shellHelper.println("Text in CYAN", PromptColor.CYAN);
        shellHelper.println("Text in GREEN", PromptColor.GREEN);
        shellHelper.println("Text in MAGENTA", PromptColor.MAGENTA);
        shellHelper.println("Text in RED", PromptColor.RED);
        shellHelper.println("Text in YELLOW", PromptColor.YELLOW);
    }

    @ShellMethod(value = "Print contextual messages demo")
    public void printContextual() {
        shellHelper.println("Text in normal message");
        shellHelper.printlnSuccess("Text of success message");
        shellHelper.printlnError("Text of error message");
        shellHelper.printlnInfo("Text of info message");
        shellHelper.printlnWarning("Text of warning message");
    }

    /*
    @ShellMethod(value = "Demo of promptWithOptions() method")
    public String promptWithOptionsDemo() {
        List<String> options = Arrays.asList("A", "B", "C");
        String answer = shellHelper.promptWithOptions("Please choose one of the letters (Z - default):", "Z", options);

        return "Chosen option: " + answer;

    }

    @ShellMethod(value = "Demo of selectFromList() method with default value from options")
    public void selectFromListDemo() {
        Map<String, String> options = new HashMap<>();
        options.put("1", "This is option ONE");
        options.put("2", "This is option TWO");
        options.put("3", "This is option THREE");
        options.put("Y", "This is option Y");
        options.put("X", "This is option X");

        String answer = shellHelper.selectFromList("Please select one of the options", options, true, "X");
        shellHelper.printSuccess("Option '" + answer  + "' chosen!");
    }

    @ShellMethod(value = "Demo of selectFromList() method with default value not in options")
    public void selectFromListDemo2() {
        Map<String, String> options = new HashMap<>();
        options.put("1", "This is option ONE");
        options.put("2", "This is option TWO");
        options.put("3", "This is option THREE");
        options.put("Y", "This is option Y");
        options.put("X", "This is option X");

        String answer = shellHelper.selectFromList("Please select one of the options (pressing enter will return Z)", options, true, "Z");
        shellHelper.printSuccess("Option '" + answer  + "' chosen!");
    }
    */
}
