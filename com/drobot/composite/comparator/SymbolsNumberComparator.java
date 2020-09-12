package com.drobot.composite.comparator;

import com.drobot.composite.component.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SymbolsNumberComparator implements Comparator<Component> {

    private static final Logger LOGGER = LogManager.getLogger(SymbolsNumberComparator.class);
    private final String symbol;

    public SymbolsNumberComparator(char symbol) {
        this.symbol = String.valueOf(symbol);
    }

    @Override
    public int compare(Component o1, Component o2) {
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < o1.size(); i++) {
            String actualSymbol = o1.getChild(i).toString();
            if (actualSymbol.equals(symbol)) {
                counter1++;
            }
        }
        for (int i = 0; i < o2.size(); i++) {
            String actualSymbol = o2.getChild(i).toString();
            if (actualSymbol.equals(symbol)) {
                counter2++;
            }
        }
        int result;
        if (counter1 == counter2) {
            LOGGER.log(Level.DEBUG, "The same symbol occurrences");
            result = o1.toString().compareToIgnoreCase(o2.toString());
        } else {
            result = Integer.compare(counter1, counter2);
        }
        return result;
    }
}
