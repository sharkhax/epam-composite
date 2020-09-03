package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolParser extends BaseParser { // TODO: 03.09.2020 logs

    public SymbolParser(Parser next) {
        super(next);
    }

    @Override
    public List<String> parse(Request request) {
        RequestType requestType = request.getRequestType();
        List<String> result;
        if (requestType != RequestType.SYMBOL && next != null) {
            result = next.parse(request);
        } else {
            String text = request.getText();
            result = parse(text);
        }
        return result;
    }

    private List<String> parse(String text) {
        String[] splitText = text.split("");
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
