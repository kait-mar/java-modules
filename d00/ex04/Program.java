import java.util.Scanner;

public class Program {
    private int max = 0;
    private int[] frequencies = new int[65535];
    private int count_char = 0;

    public int[]   analyseFrequency(String s) {

        for (char c: s.toCharArray()) {
            if (frequencies[c] == 0)
                count_char++;
            frequencies[c]++;
            if (max < frequencies[c])
                max = frequencies[c];
        }
        return frequencies;
    }

    public void displayHistogram(String input) {
        String [] chart = new String[count_char];
        int i = 0;
        for (char c: input.toCharArray()) {
            if (frequencies[c] == 0)
                continue ;
            int j = 0;
            int occ = frequencies[c] * 10 / max + 1;
            chart[i] = frequencies[c] + " ";
            for (j = 1 ; j < occ; j++) {
                chart[i] += "#";
            }
            chart[i] += " " + c + "";
            frequencies[c] = 0;
            // System.out.println(chart[i]);
            i++;
            // if (i == 10) {
            // System.out.println("chart[i]");
            // break ;

            // }
        }
        String mid;
        for (int j = 0; j < count_char - 1; j++) {
            for (i = 0; i < 10; i++) {
            if (chart[i].length() < chart[i + 1].length()) {
                mid = chart[i];
                chart[i] = chart[i + 1];
                chart[i + 1] = mid;
            }
            else if (chart[i].length() == chart[i + 1].length() &&
                chart[i].toCharArray()[chart[i].length() - 1] > chart[i].toCharArray()[chart[i + 1].length() - 1]) {
                    mid = chart[i];
                    chart[i] = chart[i + 1];
                    chart[i + 1] = mid;
            }
            }
        }
        for (int j = 0; j < count_char - 1; j++) {
            System.out.println("chart[i] " + chart[j]);
        }
}
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
    public static void main(String[] args) {
        Program myProgram = new Program();
        Scanner scanner = new Scanner(System.in);

        System.out.print("-> ");
        String s = scanner.nextLine();
        int[] frequencies = myProgram.analyseFrequency(s);
        myProgram.displayHistogram(s);
        scanner.close();
    }
}