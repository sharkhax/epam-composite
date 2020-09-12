package com.drobot.composite.parser;

import com.drobot.composite.component.Component;
import com.drobot.composite.parser.impl.ParagraphParser;
import com.drobot.composite.parser.impl.SentenceParser;
import com.drobot.composite.parser.impl.SymbolParser;
import com.drobot.composite.parser.impl.TokenParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParserChain implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(ParserChain.class);
    private static Parser instance;
    private final Parser symbolParser = new SymbolParser();
    private final Parser tokenParser = new TokenParser(symbolParser);
    private final Parser sentenceParser = new SentenceParser(tokenParser);
    private final Parser paragraphParser = new ParagraphParser(sentenceParser);

    private ParserChain() {
    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new ParserChain();
            LOGGER.log(Level.INFO, "Parser chain is created");
        }
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component result = paragraphParser.parse(text);
        LOGGER.log(Level.INFO, "Text parsing is complete");
        return result;
    }
}
