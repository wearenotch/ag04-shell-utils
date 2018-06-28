package com.ag04.utils.shell;

import de.vandermeer.asciitable.AsciiTable;

import java.util.Arrays;
import java.util.List;

/**
 * @author domagoj on 20.06.2018
 */
public class PageableTableRenderer {

    private ConsoleUserInput consoleUserInput;

    public PageableTableRenderer(ConsoleUserInput consoleUserInput) {
        this.consoleUserInput = consoleUserInput;
    }

    String render(List<String> headerRows, TableDataSource tableDataSource, int pageSize) {
        String displayResult;

        int start = 1;
        boolean finished = false;

        int total = tableDataSource.size();

        do {
            int end = start + pageSize - 1;
            if (end > total) {
                end = total;
            }
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow(headerRows);
            at.addRule();
            for (int i =start; i<=end; i++) {
                at.addRow(tableDataSource.getRowElements(i));
                at.addRule();
            }

            String errorsTable = at.render(100);
            String summaryLine = "Displaying results $start to $end of $total\n";
            displayResult = errorsTable + "\n" + summaryLine;

            if (end < total) {
                String commandLine = "Enter n or press ENTER for the next page, p for the previous page, or q to quit";
                displayResult = displayResult + commandLine;
                String answer = consoleUserInput.promptWithOptions(displayResult, "n", Arrays.asList("n", "p", "q"));
                switch (answer.toLowerCase()) {
                    case "q": return "";
                    case "n": start = start + pageSize;
                    case "p": {
                        if (start == 1) {
                            start = 1;
                        } else {
                            start = start - pageSize;
                        }
                    }
                    default: return "";
                }
            } else {
                finished = true;
            }

        } while (!finished);

        return displayResult;
    }
}
