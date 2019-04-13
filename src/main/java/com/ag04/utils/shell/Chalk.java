package com.ag04.utils.shell;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

/**
 * This class emulates blackboard chalk. Its methods return spring whose attributes are modified so
 * it will be displayed in terminal in specific ansi color.
 *
 * @author: Domagoj Madunić
 */
public class Chalk {

    /**
     * Returns supplied message String in ANSI black color.
     *
     */
    public static String black(String message) {
        return color(message, PromptColor.BLACK);
    }

    /**
     * Returns supplied message String in ANSI red color.
     *
     */
    public static String red(String message) {
        return color(message, PromptColor.RED);
    }

    /**
     * Returns supplied message String in ANSI green color.
     *
     */
    public static String green(String message) {
        return color(message, PromptColor.GREEN);
    }

    /**
     * Returns supplied message String in ANSI yellow color.
     *
     */
    public static String yellow(String message) {
        return color(message, PromptColor.YELLOW);
    }

    /**
     * Returns supplied message String in ANSI blue color.
     *
     */
    public static String blue(String message) {
        return color(message, PromptColor.BLUE);
    }

    /**
     * Returns supplied message String in ANSI magenta color.
     *
     */
    public static String magenta(String message) {
        return color(message, PromptColor.MAGENTA);
    }

    /**
     * Returns supplied message String in ANSI cyan color.
     *
     */
    public static String cyan(String message) {
        return color(message, PromptColor.CYAN);
    }

    /**
     * Returns supplied message String in ANSI white color.
     *
     */
    public static String white(String message) {
        return color(message, PromptColor.WHITE);
    }

    /**
     * Returns supplied message String as bright.
     *
     */
    public static String bright(String message) {
        return color(message, PromptColor.BRIGHT);
    }

    /**
     * Color message with given color
     *
     * @param message message to return
     * @param colorName  name of the ANSI color to print in
     * @return colored message
     */
    public static String color(String message, String colorName) {
        PromptColor color = PromptColor.valueOf(colorName);
        if (color == null) {
            throw new UnsupportedOperationException("Unknown color supplied: " + colorName);
        }
        return color(message, color);
    }

    /**
     * Color message with given color
     *
     * @param message message to return
     * @param color   color to print
     * @return colored message
     */
    public static String color(String message, PromptColor color) {
        return new AttributedStringBuilder().append(
                message,
                AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())
        ).toAnsi();
    }

}
