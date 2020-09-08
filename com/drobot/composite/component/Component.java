package com.drobot.composite.component;

public interface Component {
    boolean add(Component component);
    boolean remove(Component component);
    Component getChild(int index);
    ComponentType getComponentType();
    String toString();
}
