// package d00.ex01;

import java.util.Scanner;

public class Program {

    // private int number;

    // public void setNumber(int num) {
    //     this.number = num;
    // }

    public void isPrime(int n) {
        if (n <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (n == 2) {
            System.out.println("false " + 0);
            return ;
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
        System.out.printf("-> ");
        int number = scanner.nextInt();
        myProgram.isPrime(number);
        // System.out.println("is " + myProgram.isPrime(number));
    }
}
