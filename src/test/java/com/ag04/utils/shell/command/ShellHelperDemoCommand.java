package com.ag04.utils.shell.command;

import com.ag04.utils.shell.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

/**
 * @author domagoj on 01.08.2018
 */
@ShellComponent
public class ShellHelperDemoCommand {

    @Autowired
    private ShellHelper shellHelper;

    @ShellMethod(value = "Print text in colors")
    public void printInColorsDemo() {
        shellHelper.print("Text in WHITE", PromptColor.WHITE);
        shellHelper.print("Text in BLACK", PromptColor.BLACK);
        shellHelper.print("Text in BLUE", PromptColor.BLUE);
        shellHelper.print("Text in BRIGHT", PromptColor.BRIGHT);
        shellHelper.print("Text in CYAN", PromptColor.CYAN);
        shellHelper.print("Text in GREEN", PromptColor.GREEN);
        shellHelper.print("Text in MAGENTA", PromptColor.MAGENTA);
        shellHelper.print("Text in RED", PromptColor.RED);
        shellHelper.print("Text in YELLOW", PromptColor.YELLOW);
    }

    @ShellMethod(value = "Print contextual messages demo")
    public void printContextualDemo() {
        shellHelper.print("Text in normal message");
        shellHelper.printSuccess("Text of success message");
        shellHelper.printError("Text of error message");
        shellHelper.printInfo("Text of info message");
        shellHelper.printWarning("Text of warning message");
    }

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

    @ShellMethod(value = "Print pageable table demo")
    public void showTable() {
        int size = 20;

        List<List<String>> testData = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<String> testRow = new ArrayList<>();
            testRow.add("Row " + i + ": Column 1");
            testRow.add("Row " + i + ": Column 2");
            testData.add(testRow);
        }

        TableDataSource tableDataSource = new TableDataSource() {
            @Override
            public int size() {
                return size;
            }

            @Override
            public List<String> getRowElements(int rowNumber) {
                return testData.get(rowNumber);
            }
        };

        BasicTableRenderer tableRenderer = new BasicTableRenderer();
        PageableTableRenderer pageableTableRenderer = new PageableTableRenderer(tableRenderer, shellHelper, 4);
        System.out.println(pageableTableRenderer.render(Arrays.asList("Column 1", "Column 2"), tableDataSource));
    }

}
