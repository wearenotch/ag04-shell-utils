package com.ag04.utils.shell.config;

import com.ag04.utils.shell.ConsoleUserInput;
import com.ag04.utils.shell.ShellHelper;
import com.ag04.utils.shell.ascii.AsciiTableRenderer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jline.reader.LineReader;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.InputProvider;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.PromptProvider;

/**
 * @author domagoj on 01.08.2018
 */
@Configuration
public class CliTestAppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean PromptProvider promptProvider() {
        return new PromptProvider() {
            @Override
            public AttributedString getPrompt() {
                return new AttributedString("TEST-CLI:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.BRIGHT));
            }
        };
    }

    @Bean
    public InputProvider inputProvider(@Lazy LineReader lineReader, PromptProvider promptProvider) {
        return new InteractiveShellApplicationRunner.JLineInputProvider(lineReader, promptProvider);
    }

    @Bean
    public ExitCodeExceptionMapper exitCodeExceptionMapper() {
        return exception -> {
            Throwable e = exception;
            while (e != null && !(e instanceof ExitRequest)) {
                e = e.getCause();
            }
            return e == null ? 1 : ((ExitRequest) e).status();
        };
    }

    @Bean
    public ConsoleUserInput consoleUserInput(@Lazy LineReader lineReader) {
        return new ConsoleUserInput(lineReader);
    }

    @Bean
    public ShellHelper shellHelper(@Lazy LineReader lineReader) {
        ShellHelper shellHelper = new ShellHelper(lineReader);
        return shellHelper;
    }

    @Bean
    public AsciiTableRenderer asciiTableRenderer(ObjectMapper objectMapper) {
        AsciiTableRenderer asciiTableRenderer = new AsciiTableRenderer(objectMapper);
        return  asciiTableRenderer;
    }
}
