package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataReaderFromCsv implements DataReader {
    private static final int rowToSkip = 1;

    @Override
    public List<String> readData(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .skip(rowToSkip)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + file);
        }
    }
}
