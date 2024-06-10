package ex05;

public class Program {
    public static void main(String[] args) {
        Menu menu;
        if (args.length > 1) {
            System.err.println("IllegalArgument");
            return ;
        }
        if (args.length == 1 && !args[0].equals("--profile=dev")) {
            System.err.println("IllegalArgument");
            return ;
        }
        // if (args.length == 0)
        //     menu = new Menu(Mode.PROD);
        // else
            menu = new Menu(Mode.DEV);
        menu.lunch();
    }
}
