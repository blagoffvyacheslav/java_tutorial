package com.dmdev.hw10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Task1 {

    public static void main(String[] args) throws IOException {
        Path csvFirst = Path.of("resources", "dmdev.csv");
        Path csvSecond = Path.of("resources", "dmdev-2.csv");
        Path csvResult = Path.of("resources", "result.csv");
        Files.createFile(csvResult);
        Iterator<String[]> arrCsvFirstIter;
        Iterator<String[]> arrCsvSecondIter;
        try (Stream<String> linesCsvFirst = Files.lines(csvFirst); Stream<String> linesCsvSecond = Files.lines(csvSecond)) {
            arrCsvFirstIter = csvTransformValuesIterator(linesCsvFirst);
            arrCsvSecondIter = csvTransformValuesIterator(linesCsvSecond);
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(csvResult, StandardOpenOption.APPEND)) {
            bufferedWriter.write("ID,NAME,PRICE");
            bufferedWriter.newLine();
            while (arrCsvFirstIter.hasNext()) {
                while (arrCsvSecondIter.hasNext()) {
                    String[] first = Arrays.stream(arrCsvFirstIter.next()).toArray(String[]::new);
                    String[] second = Arrays.stream(arrCsvSecondIter.next()).toArray(String[]::new);
                    if (first[0].equals(second[0])) {
                        String[] newLine = {first[0], second[1], first[1]};
                        bufferedWriter.write(String.join(";", newLine));
                        bufferedWriter.newLine();

                    }

                }
            }
        }
    }

    public static Iterator<String[]> csvTransformValuesIterator(Stream<String> lines) {
        return Arrays.stream(lines.skip(1).map(s -> s.split(";")).toArray(String[][]::new)).iterator();
    }

}
