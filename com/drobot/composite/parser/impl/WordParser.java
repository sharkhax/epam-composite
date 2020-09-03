package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordParser extends BaseParser {

    private static final String WORD_REGEX = "";

    public WordParser(Parser next) {
        super(next);
    }

    @Override
    public List<String> parse(Request request) {
        RequestType requestType = request.getRequestType();
        List<String> result;
        if (requestType != RequestType.WORD && next != null) {
            result = next.parse(request);
        } else {
            String text = request.getText();
            result = parse(text);
        }
        return result;
    }

    private List<String> parse(String text) {
        String[] splitText = text.split(WORD_REGEX);
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
