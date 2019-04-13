package com.ag04.utils.shell.command;

import com.ag04.utils.shell.InputReader;
import com.ag04.utils.shell.table.ascii.BasicTableRenderer;
import com.ag04.utils.shell.table.ascii.PageableTableRenderer;
import com.ag04.utils.shell.table.TableDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ShellComponent
public class TableAsciiDemo {

    @Autowired
    private InputReader inputReader;

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
        PageableTableRenderer pageableTableRenderer = new PageableTableRenderer(tableRenderer, inputReader, 4);
        System.out.println(pageableTableRenderer.render(Arrays.asList("Column 1", "Column 2"), tableDataSource));
    }

}
