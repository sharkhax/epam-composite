package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TokenParser extends BaseParser { // TODO: 03.09.2020 logs

    private static final String TOKEN_REGEX = "\\s+";

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
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
