package com.drobot.composite.parser;

import com.drobot.composite.component.Component;

public interface Parser {
    Component parse(String text);
}
