package com.drobot.composite.component;

public class WordLeaf implements Component { // TODO: 03.09.2020 logs

    private final char[] word;

    public WordLeaf(char[] word) {
        this.word = word;
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
    public String toString() {
        return String.valueOf(word);
    }
}
