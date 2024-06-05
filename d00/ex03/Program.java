// package d00.ex03;

import java.util.Scanner;

public class Program {
    private int progress = 0;
    // private int reverse = 0;

    public int min(int a, int b) {
        if (a >= b)
            return b;
        return a;
    }

    public void reverse() {
        int m = 0;
        while (this.progress != 0) {
            m = m * 10 + (this.progress % 10);
            this.progress /= 10;
        }
        this.progress = m;
    }

    public void printProgress() {
        int i = 1;
        while (this.progress != 0) {
            System.out.print("  Week " + i + " ");
            int res = this.progress % 10;
            this.progress /= 10;
            for (int j = 0; j < res; j++)
                System.out.print("=");
            System.out.println(">");
            i++;
        }
    }

    public static void main(String args[]) {
        Program myProgram = new Program();
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 18; i++) { // test for over 18 and test if the entered grades are not 5
            String week = scan.nextLine();
            if (week.equals("42") == true)
                break;
            if (week.equals("") == false && week.equals("Week " + i) == false) {
                System.out.println("IllegalArgument");
                scan.close(); // TO VERIFY LATER
                System.exit(-1);
            }
            int min = 9;
            for (int j = 0; j < 5; j++) {
                int n = scan.nextInt();
                // System.out.print("[" + n + "]");
                min = myProgram.min(min, n);
            }
            scan.nextLine(); // consume the next line left in buffer
            if (myProgram.progress == 0)
                myProgram.progress = min;
            else
                myProgram.progress = myProgram.progress * 10 + min;
            // myProgram.len++;
            // System.out.println("min => " + min);

        }
        System.out.println(myProgram.progress);
        myProgram.reverse();
        myProgram.printProgress();
        scan.close();
    }
}
