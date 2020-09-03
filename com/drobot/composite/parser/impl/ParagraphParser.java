package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends BaseParser {

    private static final String PARAGRAPH_REGEX = "\\n(\\s){4}|\\s{4}|[\\t]+";

    public ParagraphParser(Parser next) {
        super(next);
    }

    @Override
    public List<String> parse(Request request) {
        List<String> result;
        RequestType requestType = request.getRequestType();
        if (requestType != RequestType.PARAGRAPH && next != null) { // TODO: 03.09.2020 логи
            result = next.parse(request);
        } else {
            String text = request.getText();
            result = parse(text);
        }
        return result;
    }

    private List<String> parse(String text) {
        String[] splitText = text.split(PARAGRAPH_REGEX);
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
