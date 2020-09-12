package com.drobot.composite.parser.impl;

import com.drobot.composite.component.Component;
import com.drobot.composite.component.ComponentContainer;
import com.drobot.composite.component.ComponentType;
import com.drobot.composite.interpreter.impl.MathInterpreter;
import com.drobot.composite.parser.Parser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParser extends BaseParser {

    private static final Logger LOGGER = LogManager.getLogger(TokenParser.class);
    private static final String TOKEN_REGEX = "\\s+";
    private static final String MATH_REGEX = "[0-9+\\-*/()]{3,}";

    public TokenParser(Parser next) {
        super(next);
        if (next == null) {
            LOGGER.log(Level.DEBUG, "Next parser is null. It was set to SymbolParser");
            setNext(new SymbolParser());
        }
    }

    @Override
    public Component parse(String text) {
        Component result = new ComponentContainer(ComponentType.SENTENCE);
        List<String> tokens = parseText(text);
        for (String token : tokens) {
            Component nextComponent = next.parse(token);
            result.add(nextComponent);
        }
        return result;
    }

    private List<String> parseText(String text) {
        String[] splitText = text.split(TOKEN_REGEX);
        List<String> result = new ArrayList<>();
        for (String token : splitText) {
            if (token.isEmpty() || token.isBlank()) {
                continue;
            }
            Pattern pattern = Pattern.compile(MATH_REGEX);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                MathInterpreter interpreter = new MathInterpreter();
                token = interpreter.interpret(token);
            }
            result.add(token);
        }
        return result;
    }
}
