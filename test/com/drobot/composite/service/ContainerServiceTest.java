package test.com.drobot.composite.service;

import com.drobot.composite.component.Component;
import com.drobot.composite.parser.Parser;
import com.drobot.composite.parser.ParserChain;
import com.drobot.composite.parser.impl.TokenParser;
import com.drobot.composite.service.ContainerService;
import org.testng.annotations.Test;

import java.util.List;


public class ContainerServiceTest {

    @Test
    public void sortParagraphsBySentencesNumberTest() {
        Parser parser = ParserChain.getInstance();
        String text = "Hello. The. Sos.\tSad. Story.\tBla bla. Bla. Bla. Bla.\tBla.";
        Component container = parser.parse(text);
        ContainerService service = new ContainerService();
        List<Component> componentList = service.sortParagraphsBySentencesNumber(container);
        System.out.println(componentList);
    }

    @Test
    public void sortSentenceByTokensLengthTest() {
        String text = "Hello. Tdheasd. Sos. SDASDDDDDD";
        Parser parser = new TokenParser(null);
        Component container = parser.parse(text);
        ContainerService service = new ContainerService();
        List<Component> componentList = service.sortSentenceByTokensLength(container);
        System.out.println(componentList);
    }

    @Test
    public void sortSentenceByWordsLengthTest() {
        String text = "Hello. Tdhe. Sos. SDASDDDDDD";
        Parser parser = new TokenParser(null);
        Component container = parser.parse(text);
        ContainerService service = new ContainerService();
        List<Component> componentList = service.sortSentenceByTokensLength(container);
        System.out.println(componentList);
    }



    @Test
    public void sortTokensBySymbolsOccurrencesNumberTest() {
        String text = "Sell hold helllo helllllllllll sold.";
        Parser parser = new TokenParser(null);
        Component container = parser.parse(text);
        ContainerService service = new ContainerService();
        List<Component> componentList = service.sortTokensBySymbolsOccurrencesNumber(container, 'l');
        System.out.println(componentList);
    }
}
