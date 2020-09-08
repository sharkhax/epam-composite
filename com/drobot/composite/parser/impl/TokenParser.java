package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParser extends BaseParser { // TODO: 03.09.2020 logs

    private static final String TOKEN_REGEX = "\\s+";
    private static final String MATH_REGEX = "[0-9+\\-*/()]";

    public TokenParser(Parser next) {
        super(next);
    }

    @Override
    public List<String> parse(Request request) {
        List<String> result;
        RequestType requestType = request.getRequestType();
        if (requestType != RequestType.TOKEN && next != null) {
            result = next.parse(request);
        } else {
            String text = request.getText();
            result = parse(text);
        }
        return result;
    }

    private List<String> parse(String text) {
        String[] splitText = text.split(TOKEN_REGEX);
        List<String> result = new ArrayList<>();
        for (String token : splitText) {
            if (token.isEmpty() || token.isBlank()) {
                continue;
            }
            Pattern pattern = Pattern.compile(MATH_REGEX);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                // token = interpret(); // TODO: 07.09.2020
            }
            result.add(token);
        }
        return result;
    }
}
