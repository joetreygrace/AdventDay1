package com.company;

import com.company.input_handling.InputReader;
import com.company.input_handling.TextFileInputReaderImpl;
import com.company.input_handling.TextFileReader;

import java.nio.file.Path;

public class App {
    public static final String DEPTHS_INPUT_TXT_PATH = "src/com/resources/depth_inputs.txt";

    public static void main(String[] args) {
        InputReader inputReader = new TextFileInputReaderImpl(new TextFileReader(Path.of(DEPTHS_INPUT_TXT_PATH)));
        DepthIncreasesCounter counter = new DepthIncreasesCounter();
        System.out.println(counter.calculate(inputReader.processDepthsInput()));
    }
}
