package d00.ex04;

import java.util.Scanner;

public class Program {

    public int[]   analyseFrequency(String s) {
        int[] frequencies = new int[65535];

        for (char c: s.toCharArray()) {
            frequencies[c]++;
        }
        return frequencies;
    }

    public void displayHistogram(int[] input) {
        
    }

    public static void main(String[] args) {
        Program myProgram = new Program();
        Scanner scanner = new Scanner(System.in);

        System.out.print("-> ");
        String s = scanner.nextLine();
        int[] frequencies = myProgram.analyseFrequency(s);
        myProgram.displayHistogram(frequencies);
        scanner.close();
    }
}
