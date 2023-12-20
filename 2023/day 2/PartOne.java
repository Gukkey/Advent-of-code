import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        int id = 1;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            if (checkConfiguration(sc.nextLine().replaceAll("^.*:", "").trim())) {
                sum += id;
            }
            id++;
        }
        System.out.println(sum);
    }

    public static boolean checkConfiguration(String s) {
        final int red = 12;
        final int green = 13;
        final int blue = 14;
        AtomicBoolean flag = new AtomicBoolean(true);
        String[] cubeSet = s.split("\\s*;\\s*");
        for (int i = 0; i < cubeSet.length; i++) {
            // String[] cube = cubeSet[i].split("\\s*,\\s*");
            cubeSet[i].lines().flatMap(x -> Arrays.stream(x.split("\\s*,\\s*"))).forEach(y -> {
                if (y.contains("blue") && Integer.parseInt(y.replaceAll("[^\\d]", "")) > blue
                        || y.contains("green") && Integer.parseInt(y.replaceAll("[^\\d]", "")) > green
                        || y.contains("red") && Integer.parseInt(y.replaceAll("[^\\d]", "")) > red) {
                    flag.set(false);
                }
            });
        }
        return flag.get();
    }
}
