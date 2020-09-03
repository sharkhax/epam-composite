package com.drobot.composite.component;

import java.util.ArrayList;
import java.util.List;

public class ComponentContainer implements Component { // TODO: 03.09.2020 logs

    private static ComponentContainer instance;
    private final List<Component> components;

    private ComponentContainer() {
        components = new ArrayList<>();
    }

    public static ComponentContainer getInstance() {
        if (instance == null) {
            instance = new ComponentContainer();
        }
        return instance;
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            sb.append(component.toString());
        }
        return sb.toString();
    }
}
