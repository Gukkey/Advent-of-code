import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PartTwo {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int calibrationValue = getCalibrationValue(s);
            sum += calibrationValue;
        }
        System.out.println(sum);
    }

    public static int getCalibrationValue(String s) {
        Set<Character> set = new HashSet<>();
        set.add('s');
        set.add('t');
        set.add('e');
        set.add('f');
        set.add('n');
        set.add('o');

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        AtomicInteger firstValue = new AtomicInteger(-1);
        AtomicInteger lastValue = new AtomicInteger(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                int limit = Math.min(i + 5, s.length());
                int finalI = i;
                map.forEach((key, value) -> {
                    if(s.substring(finalI, limit).startsWith(key)){
                        if (firstValue.get() == -1) {
                            firstValue.set(value);
                        }
                        lastValue.set(value);
                    }
                });
            } else if (Character.isDigit(c)) {
                if (firstValue.get() == -1) {
                    firstValue.set(Character.getNumericValue(c));
                }
                lastValue.set(Character.getNumericValue(c));
            }
        }
        return firstValue.get() * 10 + lastValue.get();
    }
}
