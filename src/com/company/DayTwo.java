package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DayTwo {
    private static int depth, horizontal, aim;

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src/com/resources/day_2.txt")).map(s -> s.split(" ")).forEach(DayTwo::parse);
        System.out.println(depth * horizontal);
    }

    private static void parse(String[] s) {
        int amount = Integer.parseInt(s[1]);
        switch (s[0]){
            case "forward" -> {
                horizontal += amount;
                depth += aim * amount;
            }
            case "up" -> aim -= amount;
            case "down" -> aim += amount;
        }
    }
}
