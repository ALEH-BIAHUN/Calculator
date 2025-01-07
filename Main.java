import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String VALIDATION_OF_ARITHMETIC_OPERATION_INPUT = "^(\\d|10)\\s*([+\\-*/])\\s*(\\d|10)$";

    public static void main(String[] args) {
        System.out.println("Введите математическое выражение (например, 1 + 2):");

        String input = new Scanner(System.in).nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        ParsedExpression parsedExpression = parseExpression(input);

        validateDivideByZero(parsedExpression);

        validateNumbers(parsedExpression);

        return String.valueOf(performOperation(parsedExpression));
    }

    private static ParsedExpression parseExpression(String input) throws Exception {
        input = input.trim();

        Pattern pattern = Pattern.compile(VALIDATION_OF_ARITHMETIC_OPERATION_INPUT);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new Exception("Строка не является математической операцией и не удовлетворяет заданию.");
        }

        int num1 = Integer.parseInt(matcher.group(1));
        String operator = matcher.group(2);
        int num2 = Integer.parseInt(matcher.group(3));

        return new ParsedExpression(num1, operator, num2);
    }

    private static void validateDivideByZero(ParsedExpression expression) throws ArithmeticException {
        if (expression.operator.equals("/") && expression.num2 == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
    }

    private static void validateNumbers(ParsedExpression expression) throws Exception {
        if (expression.num1 < 1 || expression.num1 > 10 || expression.num2 < 1 || expression.num2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }
    }

    private static int performOperation(ParsedExpression expression) throws Exception {
        return switch (expression.operator) {
            case "+" -> expression.num1 + expression.num2;
            case "-" -> expression.num1 - expression.num2;
            case "*" -> expression.num1 * expression.num2;
            case "/" -> expression.num1 / expression.num2;
            default -> throw new Exception("Недопустимая операция.");
        };
    }

    static class ParsedExpression {
        int num1;
        String operator;
        int num2;

        ParsedExpression(int num1, String operator, int num2) {
            this.num1 = num1;
            this.operator = operator;
            this.num2 = num2;
        }
    }
}