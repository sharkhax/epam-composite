package com.drobot.composite.component;

public class SymbolLeaf implements Component {

    private final char symbol;
    private final ComponentType componentType = ComponentType.SYMBOL;

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
