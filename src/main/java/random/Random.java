package random;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class Random {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("Date: " + date
                + "\nTime: " + time +
                "\nDateTime: " + datetime +
                "\nDay Of Week: " + DayOfWeek.of(datetime.get(ChronoField.DAY_OF_WEEK)));

        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(Duration.between(LocalTime.now().minusHours(1), LocalTime.now()).getSeconds());
        System.out.println(Period.between(LocalDate.now().minusWeeks(1), LocalDate.now()).getDays());

        System.out.println(LocalDate.parse("20211130", DateTimeFormatter.BASIC_ISO_DATE).getMonth());

        twoSum(new int[]{3, 2, 4}, 6);
    }


    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (comp.containsKey(nums[i]))
                return new int[]{comp.get(nums[i]), i};
            else {
                comp.put((target - nums[i]), i);
            }
        }
        return new int[]{};
    }

}
