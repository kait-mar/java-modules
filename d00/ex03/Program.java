// package d00.ex03;

import java.util.Scanner;

public class Program {
    private int progress = 0;
    private static String[] numbers_str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 
    // private int reverse = 0;
    private static int toInt(String input) {
        for (int i = 0; i < 10; i++) {
            if (numbers_str[i].equals(input))
                return i;
        }
        return -1;
    }

    private static boolean check_grades(String grades) {
        int count = 0;
        for (char c: grades.toCharArray() ) {
            if (c == ' ')
                continue;
            if (c < '1' || c > '9')
                return false ;
            count++;
        }
        return (count == 5);
    }

    public int min(int a, int b) {
        if (a >= b)
            return b;
        return a;
    }

    public void reverse() {
        int m = 0;
        System.out.println("progress before reverse " + this.progress);
        while (this.progress != 0) {
            m = m * 10 + (this.progress % 10);
            this.progress /= 10;
        }
        this.progress = m;
        System.out.println("progress after reverse " + this.progress);
    }

    public void printProgress() {
        int i = 1;
        String line = "";
        while (this.progress != 0) {
            line += "Week " + i + " ";
            int res = this.progress % 10;
            this.progress /= 10;
            for (int j = 0; j < res; j++)
                line += "=";
            line += ">\n";
            i++;
        }
        System.out.print(line);
    }

    public static void main(String args[]) {
        Program myProgram = new Program();
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 18; i++) { // test for over 18 and test if the entered grades are not 5
            String week = scan.nextLine();
            // System.out.println("week [" + week);
            if (week.equals("42") == true)
                break;
            if (week.length() == 0 || week.equals("Week " + i) == false) {
                System.out.println("IllegalArgument");
                scan.close(); // TO VERIFY LATER
                System.exit(-1);
            }
            int min = 9;
            int j;
            String grades = scan.nextLine();
            // System.out.println("[" + grades + "] " + grades.length());
            if (check_grades(grades) == false){
                System.out.println("IllegalArgument3");
                scan.close(); // TO VERIFY LATER
                System.exit(-1);
            }
            Scanner grades_scanner = new Scanner(grades);
            // grades_scanner.useDelimiter(" ");
            for (j = 0; j < 5; j++) {
                // int n = scan.nextInt();
                String num = grades_scanner.next();
                // System.out.print("num [" + num + "]");
                int n = toInt(num);
                if (n <= 0 || n > 9) {
                    System.out.println("IllegalArgument222");
                    scan.close(); // TO VERIFY LATER
                    System.exit(-1);
                }
                min = myProgram.min(min, n);
            }
            // scan.nextLine(); // consume the next line left in buffer
            // System.out.print("[" + j + "]");
            // String grades = = scan.nextLine();
            if (myProgram.progress == 0)
                myProgram.progress = min;
            else
                myProgram.progress = myProgram.progress * 10 + min;
            // myProgram.len++;
            // System.out.println("min => " + min);

        }
        // System.out.println(myProgram.progress);
        myProgram.reverse();
        myProgram.printProgress();
        scan.close();
    }
}
