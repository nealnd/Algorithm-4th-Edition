package Exercise1_1;
import java.util.Scanner;

public class Exercise1_1_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                continue;  // 跳过空行
            }
            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                System.out.println("输入格式错误，请输入名字和两个整数");
                continue;
            }

            String name = parts[0];
            int num1 = Integer.parseInt(parts[1]);
            int num2 = Integer.parseInt(parts[2]);

            if (num2 == 0) {
                System.out.printf("%s %d %d 无法计算（除数为零）\n", name, num1, num2);
                continue;
            }

            double result = (double) num1 / num2;
            System.out.printf("%s %d %d %.3f\n", name, num1, num2, result);
        }

        scanner.close();
    }
}
