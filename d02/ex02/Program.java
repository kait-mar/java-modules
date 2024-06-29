package ex02;


public class Program {

    private static void terminate() {
        System.err.println("IllegalArgument");
        System.exit(0);
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            terminate();
        }
        String[]  arr = args[0].split("=");
        if (arr.length != 2)
            terminate();
        if (!arr[0].equals("--current-folder"))
            terminate();
        try {
            FileManager fileManager = new FileManager(arr[1]);
            fileManager.lunch();

        } catch (Exception e) {

        }
    }
}
