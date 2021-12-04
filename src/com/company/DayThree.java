package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayThree {

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

        //Part Two

        int oxygenRating = findRating(codes, "Oxygen");
        int co2Rating = findRating(codes, "CO2");
        System.out.println(oxygenRating * co2Rating);
    }

    private static int findRating(List<String> codes, String gasName) {
        String ratingCode = null;
        for (int i = 0; i < codes.get(0).length(); ++i) {
            int ones = 0;
            for (String code : codes) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = codes.size() - ones;
            List<String> newCodes = new ArrayList<>();
            for (String code : codes) {
                if (ones >= zeros) {
                    if ((gasName.equals("Oxygen") && code.charAt(i) == '1') ||
                            (gasName.equals("CO2") && code.charAt(i) == '0')) {
                        newCodes.add(code);
                    }
                } else {
                    if ((gasName.equals("Oxygen") && code.charAt(i) == '0') ||
                            (gasName.equals("CO2") && code.charAt(i) == '1')) {
                        newCodes.add(code);
                    }
                }
            }

            codes = newCodes;
            if (codes.size() == 1) {
                ratingCode = codes.get(0);
                break;
            }
        }

        return Integer.parseInt(ratingCode, 2);
    }
}