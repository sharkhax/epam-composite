package com.drobot.composite.comparator;

import com.drobot.composite.component.Component;

import java.util.Comparator;

public class TokensLengthComparator implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        int size1 = o1.size();
        int size2 = o2.size();
        return Integer.compare(size1, size2);
    }
}
