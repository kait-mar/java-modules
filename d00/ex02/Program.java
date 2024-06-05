import java.util.Scanner;

public class Program { // test two input numbers in the same line. fix arrow output

    private int number = 0;

    public void incrementNumber() {
        this.number++;
    }

    public boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        int div = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                div++;
            if (div != 0) {
                return false;
            }
        }
        return true;
    }

    public int  sum(int n) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Program myProgram = new Program();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int query = scanner.nextInt();
            if (query == 42) {
                System.out.println("Count of coffee-request : " + myProgram.number);
                break;
            }
            if (myProgram.isPrime(myProgram.sum(query)) == true)
                myProgram.incrementNumber();
        }
        scanner.close();
    }
}
