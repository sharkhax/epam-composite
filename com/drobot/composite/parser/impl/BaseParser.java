package com.drobot.composite.parser.impl;

import com.drobot.composite.parser.Parser;

public abstract class BaseParser implements Parser {

    protected Parser next;

    protected BaseParser(Parser next) {
        this.next = next;
    }

    public void setNext(Parser parser) {
        this.next = parser;
    }
}
