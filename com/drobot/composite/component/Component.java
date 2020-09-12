package com.drobot.composite.component;

public interface Component {
    boolean add(Component component);
    boolean remove(Component component);
    Component getChild(int index);
    int size();
    ComponentType getComponentType();
    String toString();
}
