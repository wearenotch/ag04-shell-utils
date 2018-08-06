package com.ag04.utils.shell;

import java.util.Arrays;
import java.util.List;

/**
 * @author domagoj on 20.06.2018
 */
public class PageableTableRenderer implements TableRenderer {
    public static final int DEFAULT_PAGE_SIZE = 15;

    private BasicTableRenderer basicTableRenderer;
    private int pageSize;
    private ShellHelper shellHelper;

    public PageableTableRenderer(ShellHelper shellHelper) {
        this(new BasicTableRenderer(), shellHelper, DEFAULT_PAGE_SIZE);
    }

    public PageableTableRenderer(ShellHelper shellHelper, int tableSize, int pageSize) {
        this(new BasicTableRenderer(tableSize), shellHelper, pageSize);
    }

    public PageableTableRenderer(BasicTableRenderer basicTableRenderer, ShellHelper shellHelper, int pageSize) {
            this.basicTableRenderer = basicTableRenderer;
            this.pageSize = pageSize;
            this.shellHelper = shellHelper;
    }

    @Override
    public String render(List<String> headers, TableDataSource tableDataSource) {
        PageableTableDataSource pageableTableDataSource = new PageableTableDataSource(tableDataSource);
        int total = tableDataSource.size();

        int i = 0;
        String displayResult;
        do {
            pageableTableDataSource.setIndex(i);
            String errorsTable = basicTableRenderer.render(headers, pageableTableDataSource);
            String summaryLine = "Displaying results " + i + " to " + (i + pageableTableDataSource.size()) + " of " + total + "\n";
            displayResult = errorsTable + "\n" + summaryLine;
            if (total - i <= pageSize) {
                break;
            }

            String commandLine = "Enter n or press ENTER for the next page, p for the previous page, or q to quit";
            displayResult = displayResult + commandLine;
            String answer = shellHelper.promptWithOptions(displayResult, "n", Arrays.asList("n", "p", "q"));
            switch (answer.toLowerCase()) {
                case "q":
                    return "";
                case "n": {
                    i += pageSize;
                    continue;
                }
                case "p": {
                    if (i != 0) i -= pageSize;
                    continue;
                }
                default: return "";
            }
        } while (i < total);
        return displayResult;
    }

    private class PageableTableDataSource implements TableDataSource {
        private int index;
        private TableDataSource tableDataSource;

        PageableTableDataSource(TableDataSource tableDataSource) {
            this.tableDataSource = tableDataSource;
        }

        @Override
        public int size() {
            int total = tableDataSource.size();
            if (index + pageSize < total) {
                return pageSize;
            } else {
                return total - index;
            }
        }

        @Override
        public List<String> getRowElements(int rowNumber) {
            return tableDataSource.getRowElements(index + rowNumber);
        }

        void setIndex(int index) {
            this.index = index;
        }
    }

    // ---- set /get methods ---------------------------------------------------------------------------------

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
