package leetcode;

import java.util.*;

public class Events {
    public int events(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int res = 0, n = events.length, i = 0;

        for (int d = 1; d < 100000; ++d) {
            while(!queue.isEmpty() && d > queue.peek()) queue.poll();
            while(i < n && d == events[i][0]) queue.offer(events[i++][1]);
            if(!queue.isEmpty()) ++res; queue.poll();
        }
        List<Integer> resr = new ArrayList<>();
        Set<Character> char1 = new HashSet<>();
        Object[] objects = char1.toArray(new Character[0]);

        Map<String, Integer> strings = new HashMap<>();
//        Set<Map.Entry<String, Integer>> entries = strings.
        return res;
    }
}
