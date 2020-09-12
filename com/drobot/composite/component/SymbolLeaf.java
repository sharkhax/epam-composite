package com.drobot.composite.component;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolLeaf implements Component {

    private static final Logger LOGGER = LogManager.getLogger(SymbolLeaf.class);
    private final char symbol;
    private final ComponentType componentType = ComponentType.SYMBOL;

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean add(Component component) {
        LOGGER.log(Level.FATAL, "It is not allowed to use SymbolLeaf.add() method");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        LOGGER.log(Level.FATAL, "It is not allowed to use SymbolLeaf.remove() method");
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        LOGGER.log(Level.FATAL, "It is not allowed to use SymbolLeaf.getChild() method");
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        LOGGER.log(Level.FATAL, "It is not allowed to use SymbolLeaf.size() method");
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    public boolean isLetterOrDigit() {
        return Character.isLetterOrDigit(symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
