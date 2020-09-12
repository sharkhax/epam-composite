package test.com.drobot.composite.parser;

import com.drobot.composite.component.Component;
import com.drobot.composite.exception.ReaderException;
import com.drobot.composite.parser.Parser;
import com.drobot.composite.parser.ParserChain;
import com.drobot.composite.reader.DataReader;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserChainTest {

    @Test
    public void parseTest() {
        Parser parser = ParserChain.getInstance();
        DataReader reader = new DataReader();
        String text = "";
        String expected = "";
        try {
            text = reader.readFile();
            expected = reader.readFile("data/expected_text.txt");
        } catch (ReaderException e) {
            fail(e.getMessage());
        }
        Component container = parser.parse(text);
        assertEquals(container.toString(), expected);
    }
}
