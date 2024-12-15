import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> righList = new ArrayList<>();
        while (sc.hasNextLine()) {
            leftList.add(sc.nextInt());
            righList.add(sc.nextInt());
        }
        Collections.sort(righList);
        int sum = 0;
        for (int a : leftList) {
            int tempCount = 0;
            for (int j = 0; j < righList.size(); j++) {
                int b = righList.get(j);
                if (b > a) {
                    break;
                } else if (b == a) {
                    tempCount++;
                }
            }
            System.out.println(a + " has appeared " + tempCount + " times");
            sum += a * tempCount;
        }
        System.out.println("The sum is " + sum);
        sc.close();
    }
}
