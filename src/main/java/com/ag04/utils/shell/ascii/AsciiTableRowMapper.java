package com.ag04.utils.shell.ascii;

/**
 * @author dmadunic on 26.07.2018
 */
public interface AsciiTableRowMapper<E> {

    Object[] mapToArray(E element);

}
