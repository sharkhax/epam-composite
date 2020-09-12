package com.drobot.composite.interpreter.impl;

import com.drobot.composite.interpreter.Interpreter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathInterpreter implements Interpreter {

    private static final Logger LOGGER = LogManager.getLogger(MathInterpreter.class);

    @Override
    public String interpret(String text) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String result = "";
        try {
            result = String.valueOf(engine.eval(text));
            LOGGER.log(Level.DEBUG, "Interpret complete");
        } catch (ScriptException e) {
            LOGGER.log(Level.ERROR, "Eval error: " + text, e);
        }
        return result;
    }
}
