public class ParsedExpression {
    private final int num1;
    private final String operator;
    private final int num2;

    public ParsedExpression(int num1, String operator, int num2) {
        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public String getOperator() {
        return operator;
    }

    public int getNum2() {
        return num2;
    }
}