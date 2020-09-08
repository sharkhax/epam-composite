package com.drobot.composite.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ComponentContainer implements Component { // TODO: 03.09.2020 logs

    private static final Logger LOGGER = LogManager.getLogger(ComponentContainer.class);
    private static final char SPACE = ' ';
    private static final String PARAGRAPH_SEPARATOR = "    ";
    private static final String NEW_LINE_SYMBOL = "\n";
    private final List<Component> components;
    private final ComponentType componentType;

    public ComponentContainer(ComponentType componentType) {
        components = new ArrayList<>();
        this.componentType = componentType;
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
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Component firstComponent = components.get(0);
        ComponentType firstComponentType = firstComponent.getComponentType();
        if (firstComponentType == ComponentType.PARAGRAPH
                || firstComponentType == ComponentType.TEXT) {
            sb.append(PARAGRAPH_SEPARATOR);
        }
        sb.append(firstComponent.toString());

        for (int i = 1; i < components.size(); i++) {
            Component component = components.get(i);
            ComponentType componentType = component.getComponentType();
            if (componentType == ComponentType.PARAGRAPH
                    || componentType == ComponentType.TEXT) {
                sb.append(NEW_LINE_SYMBOL).append(PARAGRAPH_SEPARATOR);
            } else if (componentType != ComponentType.SYMBOL) {
                sb.append(SPACE);
            }
            sb.append(component.toString());
        }
        return sb.toString();
    }
}
