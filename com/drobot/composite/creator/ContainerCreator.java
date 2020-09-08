package com.drobot.composite.creator;

import com.drobot.composite.component.ComponentContainer;
import com.drobot.composite.component.ComponentType;
import com.drobot.composite.component.SymbolLeaf;
import com.drobot.composite.parser.Parser;
import com.drobot.composite.parser.ParserChain;
import com.drobot.composite.request.Request;
import com.drobot.composite.request.RequestType;

import java.util.List;

public class ContainerCreator {

    private final Parser parserChain = ParserChain.getInstance();

    public ComponentContainer createContainer(String text) { // TODO: 07.09.2020 logs
        ComponentContainer result = createTextContainer(text);
        return result;
    }

    private ComponentContainer createTokenContainer(String token) {
        ComponentContainer result = new ComponentContainer(ComponentType.TOKEN);
        Request request = new Request(token, RequestType.SYMBOL);
        List<String> symbols = parserChain.parse(request);
        for (String symbol : symbols) {
            SymbolLeaf leaf = new SymbolLeaf(symbol.charAt(0));
            result.add(leaf);
        }
        return result;
    }

    private ComponentContainer createSentenceContainer(String sentence) {
        ComponentContainer result = new ComponentContainer(ComponentType.SENTENCE);
        Request request = new Request(sentence, RequestType.TOKEN);
        List<String> tokens = parserChain.parse(request);
        for (String token : tokens) {
            ComponentContainer tokenContainer = createTokenContainer(token);
            result.add(tokenContainer);
        }
        return result;
    }

    private ComponentContainer createParagraphContainer(String paragraph) {
        ComponentContainer result = new ComponentContainer(ComponentType.PARAGRAPH);
        Request request = new Request(paragraph, RequestType.SENTENCE);
        List<String> sentences = parserChain.parse(request);
        for (String sentence : sentences) {
            ComponentContainer sentenceContainer = createSentenceContainer(sentence);
            result.add(sentenceContainer);
        }
        return result;
    }

    private ComponentContainer createTextContainer(String text) {
        ComponentContainer result = new ComponentContainer(ComponentType.TEXT);
        Request request = new Request(text, RequestType.PARAGRAPH);
        List<String> paragraphs = parserChain.parse(request);
        for (String paragraph : paragraphs) {
            ComponentContainer paragraphContainer = createParagraphContainer(paragraph);
            result.add(paragraphContainer);
        }
        return result;
    }
}
