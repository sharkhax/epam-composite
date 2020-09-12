package test.com.drobot.composite.reader;

import com.drobot.composite.exception.ReaderException;
import com.drobot.composite.reader.DataReader;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataReaderTest {

    @Test
    public void readFileTest() {
        DataReader reader = new DataReader();
        try {
            System.out.println(reader.readFile());
        } catch (ReaderException e) {
            fail(e.getMessage(), e);
        }
    }
}
