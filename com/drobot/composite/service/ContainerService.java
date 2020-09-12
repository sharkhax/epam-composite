package com.drobot.composite.service;

import com.drobot.composite.comparator.SentencesNumberComparator;
import com.drobot.composite.comparator.SymbolsNumberComparator;
import com.drobot.composite.comparator.TokensLengthComparator;
import com.drobot.composite.comparator.WordsLengthComparator;
import com.drobot.composite.component.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContainerService {

    private static final Logger LOGGER = LogManager.getLogger(ContainerService.class);

    public List<Component> sortParagraphsBySentencesNumber(Component text) {
        Comparator<Component> comparator = new SentencesNumberComparator();
        return sort(text, comparator);
    }

    public List<Component> sortSentenceByTokensLength(Component sentence) {
        Comparator<Component> comparator = new TokensLengthComparator();
        return sort(sentence, comparator);
    }

    public List<Component> sortSentenceByWordsLength(Component sentence) {
        Comparator<Component> comparator = new WordsLengthComparator();
        return sort(sentence, comparator);
    }

    public List<Component> sortTokensBySymbolsOccurrencesNumber(Component sentence, char symbol) {
        Comparator<Component> comparator = new SymbolsNumberComparator(symbol);
        return sort(sentence, comparator);
    }

    private List<Component> sort(Component component, Comparator<Component> comparator) {
        List<Component> result = new ArrayList<>();
        for (int i = 0; i < component.size(); i++) {
            Component child = component.getChild(i);
            result.add(child);
        }
        result.sort(comparator);
        LOGGER.log(Level.INFO, "Sorting complete");
        return result;
    }
}
