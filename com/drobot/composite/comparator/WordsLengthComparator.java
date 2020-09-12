package com.drobot.composite.comparator;

import com.drobot.composite.component.Component;
import com.drobot.composite.component.SymbolLeaf;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class WordsLengthComparator implements Comparator<Component> {

    private static final Logger LOGGER = LogManager.getLogger(WordsLengthComparator.class);

    @Override
    public int compare(Component o1, Component o2) {
        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < o1.size(); i++) {
            Component component = o1.getChild(i);
            if (component instanceof SymbolLeaf) {
                SymbolLeaf leaf = (SymbolLeaf) component;
                if (leaf.isLetterOrDigit()) {
                    size1++;
                }
            } else {
                LOGGER.log(Level.ERROR, "Wrong object contained in component, should be SymbolLeaf");
                return 0;
            }
        }
        for (int i = 0; i < o2.size(); i++) {
            SymbolLeaf leaf = (SymbolLeaf) o2.getChild(i);
            if (leaf.isLetterOrDigit()) {
                size2++;
            }
        }
        return Integer.compare(size1, size2);
    }
}
