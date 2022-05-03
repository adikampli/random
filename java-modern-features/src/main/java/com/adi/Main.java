package com.adi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Main extends Test {

    public record Point(int x, int y) {
    }

    public static void main(String[] args) {
        // Records
        var point = new Point(1, 2);
        log.info("Point X: {} ", point.x());

        // Pattern matching instanceof
        Object obj = null;
        if (obj instanceof String s) {
            log.info(s);
        }

        // Multi line strings
        String multiline = """
                    Hello
                    World
                """;

        // Switch Statement - Old way
        int k = 1;
        String val;
        switch (k) {
            case 1:
                val = "One";
                break;
            case 2:
                val = "Two";
                break;
            default:
                val = "";
        }
        log.info(val);

        // Switch Expression
        String res = switch (k) {
            case 1 -> "One";

            case 2 -> "Two";

            default -> "Def";
        };
        log.info(res);
    }
}

sealed class Test permits Main {

}