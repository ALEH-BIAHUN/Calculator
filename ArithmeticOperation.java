public class ArithmeticOperation {
    public int perform(ParsedExpression expression) throws Exception {
        return switch (expression.getOperator()) {
            case "+" -> expression.getNum1() + expression.getNum2();
            case "-" -> expression.getNum1() - expression.getNum2();
            case "*" -> expression.getNum1() * expression.getNum2();
            case "/" -> divide(expression.getNum1(), expression.getNum2());
            default -> throw new Exception("Недопустимая операция.");
        };
    }

    private int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        return num1 / num2;
    }
}