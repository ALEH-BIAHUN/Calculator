import java.util.Scanner;

public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readInput() {
        return scanner.nextLine().trim();
    }
}