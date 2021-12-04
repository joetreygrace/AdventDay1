package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {

    private static String gamma, epsilon;

    public static void main(String[] args) throws IOException {
        List<String> codes = Files.lines(Paths.get("src/com/resources/day_3.txt")).toList();

        // Part One

        String gammaRateCode = "";
        String epsilonRateCode = "";
        for (int i = 0; i < codes.get(0).length(); ++i) {
            int ones = 0;
            for (String code : codes) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }

            int zeros = codes.size() - ones;
            gammaRateCode += ones > zeros ? '1' : '0';
            epsilonRateCode += ones > zeros ? '0' : '1';
        }

        System.out.println(Integer.parseInt(gammaRateCode, 2) * Integer.parseInt(epsilonRateCode, 2));
    }

}
