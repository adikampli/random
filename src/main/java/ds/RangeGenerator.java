package ds;/*List = [1,3,5,3,7,18], non negative
step = 5, positive number

Output:
0-5 3 
5-10 2
10-15 0
15-20 1
*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RangeGenerator {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 3, 7, 18, 13);
        int step = 5;
        generateRange(list, step);
    }

    private static void generateRange(List<Integer> list, int step) {
        Map<Integer, Long> rangeMap = list.stream()
                .collect(Collectors.groupingBy((i -> {
                    int rangeEnd = step;
                    while (rangeEnd <= i) {
                        rangeEnd += step;
                    }
                    return rangeEnd;
                }), Collectors.counting()));
        Map<Integer, Long> sortedMap = new TreeMap<>(rangeMap);
        sortedMap.entrySet().forEach(i -> printRange((i.getKey() - 5), i.getKey(), i.getValue()));
    }

    static void printRange(int min, int max, long count) {
        System.out.println(min + "-" + max + ": " + count);
    }
}