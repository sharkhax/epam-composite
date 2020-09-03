package com.drobot.composite.parser;

import com.drobot.composite.request.Request;

import java.util.List;

public interface Parser {
    List<String> parse(Request request);
}
