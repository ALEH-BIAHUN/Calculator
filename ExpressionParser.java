import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    private static final String VALIDATION_OF_ARITHMETIC_OPERATION_INPUT = "^(\\d|10)\\s*([+\\-*/])\\s*(\\d|10)$";

    public ParsedExpression parse(String input) throws Exception {
        Pattern pattern = Pattern.compile(VALIDATION_OF_ARITHMETIC_OPERATION_INPUT);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new Exception("Строка не является математической операцией и не удовлетворяет заданию.");
        }

        int num1 = Integer.parseInt(matcher.group(1));
        String operator = matcher.group(2);
        int num2 = Integer.parseInt(matcher.group(3));

        validateNumbers(num1, num2, operator);
        return new ParsedExpression(num1, operator, num2);
    }

    private void validateNumbers(int num1, int num2, String operator) throws Exception {
        if (num1 < 1 || num1 > 10) {
            throw new Exception("Число " + num1 + " должно быть в диапазоне от 1 до 10 включительно.");
        }
        if (!operator.equals("/") && (num2 < 1 || num2 > 10)) {
            throw new Exception("Число " + num2 + " должно быть в диапазоне от 1 до 10 включительно.");
        }
    }
}