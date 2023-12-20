import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PartTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (sc.hasNextLine()) {
            sum += powerOfCubes(sc.nextLine().replaceAll("^.*:", "").trim());
        }
        System.out.println(sum);
    }

    private static int powerOfCubes(String s) {
        AtomicInteger blue = new AtomicInteger(1);
        AtomicInteger red = new AtomicInteger(1);
        AtomicInteger green = new AtomicInteger(1);
        String[] cubeSet = s.split("\\s*;\\s*");
        for (int i = 0; i < cubeSet.length; i++) {
            cubeSet[i].lines().flatMap(x -> Arrays.stream(x.split("\\s*,\\s*"))).forEach(y -> {
                if (y.contains("blue") && (Integer.parseInt(y.replaceAll("[^\\d]", "")) > blue.get()))  {
                    blue.set(Integer.parseInt(y.replaceAll("[^\\d]", "")));
                }
                else if(y.contains("green") && (Integer.parseInt(y.replaceAll("[^\\d]", "")) > green.get())){
                    green.set(Integer.parseInt(y.replaceAll("[^\\d]", "")));
                }
                else if(y.contains("red") && (Integer.parseInt(y.replaceAll("[^\\d]", "")) > red.get())){
                    red.set(Integer.parseInt(y.replaceAll("[^\\d]", "")));
                }
            });
        }
        return red.get() * blue.get() * green.get();
    }
}