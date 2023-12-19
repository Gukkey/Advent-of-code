import java.util.*;

public class PartOne {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String calibrationValue = getCalibrationValues(s);
            sum += Integer.parseInt(calibrationValue);
        }
        System.out.println(sum);
    }

    public static String getCalibrationValues(String s) {
        char firstValue = ' ';
        char lastValue = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if(firstValue == ' '){
                    firstValue = c;
                }
                lastValue = c;
            }
        }
        return firstValue + "" + lastValue;
    }
}
