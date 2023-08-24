import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] hoursWorked = new int[7];
        for (int i = 0; i < 7; i++) {
            hoursWorked[i] = scanner.nextInt();
        }

        int salary = calculateSalary(hoursWorked);
        System.out.println(salary);

        scanner.close();
    }

    public static int calculateSalary(int[] hoursWorked) {
        int totalSalary = 0;
        int regularRate = 100;
        int extraRate1 = 15;
        int extraRate2 = 25;
        int bonusSaturday = 25;
        int bonusSunday = 50;

        for (int i = 0; i < 7; i++) {
            if (i == 5) {
                totalSalary += hoursWorked[i] * (regularRate + bonusSaturday);
            } else if (i == 6) {
                totalSalary += hoursWorked[i] * (regularRate + bonusSunday);
            } else {
                totalSalary += hoursWorked[i] * regularRate;
            }

            if (hoursWorked[i] > 8) {
                totalSalary += (hoursWorked[i] - 8) * extraRate1;
            }

            if (i < 5) {
                if (hoursWorked[i] > 40) {
                    totalSalary += (hoursWorked[i] - 40) * extraRate2;
                }
            }
        }

        return totalSalary;
    }
}
