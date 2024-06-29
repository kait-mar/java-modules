package ex01;

public class Program {
    public static void main(String[] args) {
        // if (args.length != 2) {
        //     System.err.println("IllegalArgument");
        //     return ;
        // }
        try {
            String[] arg = new String[]{"/home/kait/Desktop/java-modules/d02/ex01/file1", "/home/kait/Desktop/java-modules/d02/ex01/file2"};
            Similarity sm = new Similarity(arg);
            sm.lunch();
            System.out.printf("Similarity = %.2f\n", sm.calculateSimilarity());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
