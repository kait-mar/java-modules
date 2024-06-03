import java.util.Scanner;

public class Program {
    private int max = 0;
    private int[] frequencies = new int[65536];

    public int[]   analyseFrequency(String s) {
        for (char c: s.toCharArray()) {
            frequencies[c]++;
            if (max < frequencies[c])
                max = frequencies[c];
        }
        return frequencies;
    }

    public void displayHistogram(String input) {
        int[] top_frequencies = new int[10];
        char[] top_characters = new char[10];
        for (int i = 0; i < 65536; i++) {
            if (frequencies[i] == 0)
                continue ;
            for (int j = 0; j < 10; j++) {
                if (frequencies[i] > top_frequencies[j]) {
                    for (int k = 9; k > j; k--) {
                        top_frequencies[k] = top_frequencies[k - 1];
                    }
                    for (int k = 9; k > j; k--) {
                        top_characters[k] = top_characters[k - 1];
                    }
                    top_characters[j] = (char) i;
                    top_frequencies[j] = frequencies[i];
                    break ;
                }
                else if (frequencies[i] == top_frequencies[j] && (char)i < top_characters[j]) {
                    for (int k = 9; k > j; k--) {
                        top_frequencies[k] = top_frequencies[k - 1];
                    }
                    for (int k = 9; k > j; k--) {
                        top_characters[k] = top_characters[k - 1];
                    }
                    top_characters[j] = (char) i;
                    top_frequencies[j] = frequencies[i];
                    break ;
                }
            }
        }
        System.out.println();

        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (top_frequencies[j] == 0)
                    break;
                int count = top_frequencies[j] * 10 / max ;//+ 1;
                if (count == i)
                    System.out.printf("%5d", top_frequencies[j]);
                else if (count > i)
                    System.out.printf("%5c", '#');
                else
                    System.out.printf("%5c", ' ');
            }
            System.out.println();
        }
        for (int j = 0; j < 10; j++) {
            System.out.printf("%5c", top_characters[j]);
        }
        System.out.println();
}
    public static void main(String[] args) {
        Program myProgram = new Program();
        Scanner scanner = new Scanner(System.in);

        System.out.print("-> ");
        String s = scanner.nextLine();
        myProgram.analyseFrequency(s);
        myProgram.displayHistogram(s);
        scanner.close();
    }
}