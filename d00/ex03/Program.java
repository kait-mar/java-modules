import java.util.Scanner;

public class Program {
    private long progress = 0;
    private static String[] numbers_str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 
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
        long m = 0;
        while (this.progress != 0) {
            m = m * 10 + (this.progress % 10);
            this.progress /= 10;
        }
        this.progress = m;
    }

    public void printProgress() {
        int i = 1;
        String line = "";
        while (this.progress != 0) {
            line += "Week " + i + " ";
            long res = this.progress % 10;
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
        for (int i = 1; i <= 18; i++) {
            String week = scan.nextLine();
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
            if (check_grades(grades) == false){
                System.out.println("IllegalArgument");
                scan.close(); // TO VERIFY LATER
                System.exit(-1);
            }
            Scanner grades_scanner = new Scanner(grades);
            for (j = 0; j < 5; j++) {
                String num = grades_scanner.next();
                int n = toInt(num);
                if (n <= 0 || n > 9) {
                    System.out.println("IllegalArgument");
                    scan.close(); // TO VERIFY LATER
                    grades_scanner.close();
                    System.exit(-1);
                }
                min = myProgram.min(min, n);
            }
            if (myProgram.progress == 0)
                myProgram.progress = min;
            else
                myProgram.progress = myProgram.progress * 10 + min;
            grades_scanner.close();
        }
        myProgram.reverse();
        myProgram.printProgress();
        scan.close();
    }
}
/** 1st example  */
// Week 1
// 5 6 7 8 9
// Week 2
// 5 6 7 8 9
// Week 3
// 5 6 7 8 9
// Week 4
// 5 6 7 8 9
// Week 5
// 5 6 7 8 9
// Week 6
// 5 6 7 8 9
// Week 7
// 5 6 7 8 9
// Week 8
// 5 6 7 8 9
// Week 9
// 5 6 7 8 9
// Week 10
// 5 6 7 8 9
// Week 11
// 5 6 7 8 9
// Week 12
// 5 6 7 8 9
// Week 13
// 5 6 7 8 9
// Week 14
// 5 6 7 8 9
// Week 15
// 5 6 7 8 9
// Week 16
// 5 6 7 8 9
// Week 17
// 5 6 7 8 9

/* 2d example  */
// Week 1
// 4 5 2 4 2
// Week 2
// 7 7 7 7 6
// Week 3
// 4 3 4 9 8
// Week 4
// 9 9 4 6 7

