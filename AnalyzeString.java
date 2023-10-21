import java.util.*;
import java.util.regex.*;
import java.lang.Math;

public class AnalyzeString {
    private String input;

    public AnalyzeString(String input) {
        this.input = input;
    }

    public void analyze() {
        HashMap<String, List<Integer>> numberAnalysis = getNumber();
        HashMap<String, StringBuilder> characterAnalysis = getCharacter();

        System.out.println("===== Analysis String program ====");
        System.out.println("Input String: " + input);

        System.out.println("\n-----Result Analysis------");
        System.out.println("Number of Characters in the String: " + input.length());
        System.out.println("All Characters: " + characterAnalysis.get("allCharacters"));
        System.out.println("Uppercase Characters: " + characterAnalysis.get("uppercaseCharacters"));
        System.out.println("Lowercase Characters: " + characterAnalysis.get("lowercaseCharacters"));
        System.out.println("Special Characters: " + characterAnalysis.get("specialCharacters"));
        System.out.println("All Numbers: " + numberAnalysis.get("allNumbers"));
        System.out.println("Even Numbers: " + numberAnalysis.get("evenNumbers"));
        System.out.println("Odd Numbers: " + numberAnalysis.get("oddNumbers"));
        System.out.println("Perfect Square Numbers: " + numberAnalysis.get("perfectSquareNumbers"));
    }

    private HashMap<String, List<Integer>> getNumber() {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> perfectSquareNumbers = new ArrayList();

        Pattern numberPattern = Pattern.compile("-?\\d+"); //số bất kì và dấu "-"
        Matcher matcher = numberPattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            allNumbers.add(number);

            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }

            double sqrt = Math.sqrt(number);
            if (sqrt == (int) sqrt) {
                perfectSquareNumbers.add(number);
            }
        }

        result.put("allNumbers", allNumbers);
        result.put("evenNumbers", evenNumbers);
        result.put("oddNumbers", oddNumbers);
        result.put("perfectSquareNumbers", perfectSquareNumbers);
        return result;
    }

    private HashMap<String, StringBuilder> getCharacter() {
        HashMap<String, StringBuilder> result = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder uppercaseCharacters = new StringBuilder();
        StringBuilder lowercaseCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char c : input.toCharArray()) {
            allCharacters.append(c);
            if (Character.isUpperCase(c)) {
                uppercaseCharacters.append(c);
            } else if (Character.isLowerCase(c)) {
                lowercaseCharacters.append(c);
            } else if (!Character.isWhitespace(c) && !Character.isDigit(c)) {
                specialCharacters.append(c);
            }
        }

        result.put("allCharacters", allCharacters);
        result.put("uppercaseCharacters", uppercaseCharacters);
        result.put("lowercaseCharacters", lowercaseCharacters);
        result.put("specialCharacters", specialCharacters);
        return result;
    }
}
