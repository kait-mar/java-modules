import java.util.Scanner;

public class Program {

    public void isPrime(int n) {
        if (n <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        int div = 0;
        int i;
        for (i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                div++;
            if (div != 0) {
                System.out.println("false " + (i - 1));
                return ;
            }
        }
        System.out.println("true " + (i - 1) );
    }

    public static void main(String[] args) {
        Program myProgram = new Program();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        myProgram.isPrime(number);
    }
}
