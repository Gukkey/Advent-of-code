import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        while (sc.hasNextLine()) {
            leftList.add(sc.nextInt());
            rightList.add(sc.nextInt());
        }
        Collections.sort(leftList);
        Collections.sort(rightList);
        int sum = 0;
        for (int i = 0; i < leftList.size(); i++) {
            sum += Math.abs(leftList.get(i) - rightList.get(i));
        }
        System.out.println(sum);
        sc.close();
    }
}