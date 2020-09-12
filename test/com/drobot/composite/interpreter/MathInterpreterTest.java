package test.com.drobot.composite.interpreter;

import com.drobot.composite.interpreter.Interpreter;
import com.drobot.composite.interpreter.impl.MathInterpreter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MathInterpreterTest {

    @Test
    public void interpretTest() {
        Interpreter interpreter = new MathInterpreter();
        String text = "2+3";
        String actual = interpreter.interpret(text);
        String expected = "5";
        assertEquals(actual, expected);
    }
}
