package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser { // TODO: 03.09.2020 логи

    private static final String SENTENCE_REGEX =
            "([.?!…]\\s)+|([.?!…]\t)+|([.?!…]\\s{4})+|([.?!…]\\n)+|([.?!…]\\n\\s{4})+";

    public SentenceParser(Parser next) {
        super(next);
    }

    @Override
    public List<String> parse(Request request) {
        List<String> result;
        RequestType requestType = request.getRequestType();
        if (requestType != RequestType.SENTENCE && next != null) {
            result = next.parse(request);
        } else {
            String text = request.getText();
            result = parse(text);
        }
        return result;
    }

    private List<String> parse(String text) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        int index = 0;
        String buffer;
        while (matcher.find(index)) {
            buffer = text.substring(index, matcher.start() + 1);
            result.add(buffer);
            index = matcher.end();
        }
        buffer = text.substring(index);
        result.add(buffer);
        return result;
    }
}
