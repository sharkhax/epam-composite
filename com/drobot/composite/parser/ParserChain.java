package com.drobot.composite.parser;

import com.drobot.composite.parser.impl.ParagraphParser;
import com.drobot.composite.parser.impl.SentenceParser;
import com.drobot.composite.parser.impl.TokenParser;
import com.drobot.composite.request.Request;

import java.util.List;

public class ParserChain implements Parser { // TODO: 03.09.2020 logs

    private static Parser instance;
    private final Parser tokenParser = new TokenParser(null);
    private final Parser sentenceParser = new SentenceParser(tokenParser);
    private final Parser paragraphParser = new ParagraphParser(sentenceParser);

    private ParserChain() {
    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new ParserChain();
        }
        return instance;
    }

    @Override
    public List<String> parse(Request request) {
        List<String> result = paragraphParser.parse(request);
        return result;
    }
}
