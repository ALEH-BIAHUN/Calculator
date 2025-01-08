public class Calculator {
    private final InputReader inputReader;
    private final ExpressionParser parser;
    private final ArithmeticOperation operation;

    public Calculator(InputReader inputReader, ExpressionParser parser, ArithmeticOperation operation) {
        this.inputReader = inputReader;
        this.parser = parser;
        this.operation = operation;
    }
    public String calculate() throws Exception {
        String input = inputReader.readInput();
        ParsedExpression expression = parser.parse(input);
        return String.valueOf(operation.perform(expression));
    }
}