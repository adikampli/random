package udemy;

import java.util.Arrays;

public class StringReverse {
    public static int howMany(String sentence) {
        Arrays.stream(sentence.trim().split(" +"))
                .filter(word -> !word.matches(".*[^A-Za-z-.,?!].*"))
                .forEach(System.out::println);
        int count = (int) Arrays.stream(sentence.split(" +"))
                .filter(word -> !word.matches(".*[^A-Za-z-.,?!].*"))
                .count();
        return count;

    }

//    public static int efficientJanitor(List<Float> weight) {
//        weight.stream().sorted();
//
//
//    }

    public String reverse(String in) {
        /**

         1. For Loop Approach

         StringBuilder reverse = new StringBuilder();
         for (int i = in.length() - 1; i >= 0; i--) {
         reverse.append(in.charAt(i));
         }
         return reverse.toString();

         2. ForEach loop approach

         String reverse = "";
         for (char c : in.toCharArray()) {
         reverse = c + reverse;
         }

         return reverse;
         **/

        // Streams reduce approach
        return Arrays.stream(in.split("")).reduce("", (a, b) -> b + a);
    }
}
