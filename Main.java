import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();
        scanner.close();

        AnalyzeString analyzer = new AnalyzeString(input);
        analyzer.analyze();
    }
}
