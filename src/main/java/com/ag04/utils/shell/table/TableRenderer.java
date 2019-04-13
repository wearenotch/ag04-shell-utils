package com.ag04.utils.shell.table;

import com.ag04.utils.shell.table.TableDataSource;

import java.util.List;

/**
 * @author mgulan on 03.08.18.
 */
public interface TableRenderer {
    String render(List<String> headers, TableDataSource tableDataSource);
}
