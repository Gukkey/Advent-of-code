import java.util.*;
import java.util.stream.Stream;

public class PartOne {
    public static void main(String[] args) {
        int id = 1;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            id++;
            if (checkConfiguration(sc.nextLine())) {
                sum += id;
            }
        }
        System.out.println(sum);
    }

    public static boolean checkConfiguration(String s) {
        final int red = 12;
        final int green = 13;
        final int blue = 14;
        String[] cubeSet = s.split("\\s*;\\s*");
        for (int i = 0; i < cubeSet.length; i++) {
            //String[] cube = cubeSet[i].split("\\s*,\\s*");
            cubeSet[i].lines().flatMap(x -> Arrays.stream(x.split("\\s*,\\s*"))).forEach(y -> {
                
            });
        }
        return false;
    }
}
