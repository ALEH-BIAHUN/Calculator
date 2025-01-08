public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputReader(), new ExpressionParser(), new ArithmeticOperation());

        System.out.println("Введите математическое выражение (например, 1 + 2):");

        try {
            String result = calculator.calculate();
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}