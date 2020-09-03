package com.drobot.composite.reader;

import com.drobot.composite.exception.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final String FILE_PATH = "data/info.txt";
    private static final Logger LOGGER = LogManager.getLogger();

    public String readFile() throws ReaderException {
        return readFile(FILE_PATH);
    }

    public String readFile(String filePath) throws ReaderException {
        try (FileReader reader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> linesList = bufferedReader.lines().collect(Collectors.toList());
            String stringFile = String.join("\n", linesList);
            LOGGER.log(Level.INFO, "File has been read");
            return stringFile;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
            throw new ReaderException(e);
        }
    }
}
