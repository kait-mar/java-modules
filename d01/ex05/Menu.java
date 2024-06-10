package ex05;

import java.util.Scanner;

import ex02.Category;
import ex03.Transaction;
import ex03.User;
import ex04.TransactionsService;

enum Mode{
    DEV,
    PROD
};

public class Menu {
    private TransactionsService transactionsService;
    private Mode mode;
    private Scanner scanner;

    public Menu(Mode mode) {
        this.transactionsService = new TransactionsService();
        this.mode = mode;
        this.scanner = new Scanner(System.in);
        
    }

    public void lunch() {
        // Scanner scanner = new Scanner(System.in);

        String menu = "1. Add a user\n" +
        "2. View user balances\n" +
        "3. Perform a transfer\n" +
        "4. View all transactions for a specific user\n" +
        "5. DEV - remove a transfer by ID\n" +
        "6. DEV - check transfer validity\n" +
        "7. Finish execution";

        while (true) {
            try {
                System.out.println(menu);
                System.out.print("-> ");
                String line = scanner.nextLine();
                line = line.trim();
                if (line.length() != 1) {
                    System.out.println("IllegalArgument\n---------------------------------------------------------");
                    continue ;
                }
                int item = Integer.parseInt(line);
                if (item == 7)
                    break ;
                command(item);
            } catch(Exception e) {
                System.err.println((e.getMessage().equals("Illegal argument") ? "" : "Error IllegalArgument: ") + e.getMessage());
                System.out.println("---------------------------------------------------------");
            }
        }
        scanner.close();
    }

    public void command(int item) {
        switch (item) {
            case 1:
                addUser();
                break;
            case 2:
                viewUserBalance();
                break;
            case 3:
                performeTransfer();
                break;
            case 4:
                viewUserTransactions();
                break;
            case 5:
                removeTransaction();
                break;
            case 6:
                checkTransferValidity();
                break;
            default:
                Default();
                break;
        }
    }

    /*
        1. Add a user
        2. View user balances
        3. Perform a transfer
        4. View all transactions for a specific user
        5. DEV - remove a transfer by ID
        6. DEV - check transfer validity
        7. Finish execution
     */
    private void addUser() {
        System.out.println("Enter a user name and a balance");
        System.out.print("-> ");
        String line =  scanner.nextLine();
        line = line.trim();
        String[] args = line.split(" ");
        if (args.length != 2)
            throw new RuntimeException("Illegal argument");
        String name = args[0];
        int balance = Integer.parseInt(args[1]);
        User user = new User(name, balance);
        transactionsService.addUser(user);
        System.out.println("User with id = " + user.getId()
         + " is added\n---------------------------------------------------------");
        
    }

    private void viewUserBalance() {
        System.out.println("Enter a user ID");
        System.out.print("-> ");
        String line =  scanner.nextLine();
        line = line.trim();
        int id = Integer.parseInt(line);
        int balance = transactionsService.retrieveUserBalance(id);
        String name = transactionsService.findUser(id).getName();
        System.out.println(name + " - " + balance);
        System.out.println("---------------------------------------------------------");
    }

    private void performeTransfer() {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        System.out.print("-> ");
        String line =  scanner.nextLine();
        line = line.trim();
        String[] args = line.split(" ");
        if (args.length != 3)
            throw new RuntimeException("Illegal argument");
        int senderId = Integer.parseInt(args[0]);
        int recipientId = Integer.parseInt(args[1]);
        int amount = Integer.parseInt(args[2]);
        transactionsService.createTransaction(senderId, recipientId, amount);
        System.out.println("The transfer is completed");
        System.out.println("---------------------------------------------------------");
    }

    private void viewUserTransactions() {
        System.out.println("Enter a user ID");
        System.out.print("-> ");
        String line =  scanner.nextLine();
        line = line.trim();
        int id = Integer.parseInt(line);
        Transaction[] tr = transactionsService.retrieveUserTransactions(id);
        String out;
        for (int i = 0; i < tr.length; i++) {
            if (tr[i].getCategory().equals(Category.CREDIT))
                out = "To " + tr[i].getRecipient().getName()
                    + "(id = " + tr[i].getRecipient().getId() + ") "
                    + tr[i].getAmount() + " with id = " + tr[i].getUuid();
            else
                out = "From " + tr[i].getSender().getName()
                + "(id = " + tr[i].getSender().getId() + ") +"
                + tr[i].getAmount() + " with id = " + tr[i].getUuid();
            System.out.println(out);
        }
        System.out.println("---------------------------------------------------------");
    }

    private void removeTransaction() {
        if (!mode.equals(Mode.DEV)) {
            System.err.println("You can't perform such action in production mode");
            System.out.println("---------------------------------------------------------");

            return ;
        }
        System.out.println("Enter a user ID and a transfer ID");
        System.out.print("-> ");
        String line =  scanner.nextLine();
        line = line.trim();
        String[] args = line.split(" ");
        if (args.length != 2)
            throw new RuntimeException("Illegal argument");
        int id = Integer.parseInt(args[0]);
        String uuid = args[1];
        Transaction tr = transactionsService.removeuserTransaction(id, uuid);
        String out;
        if (tr.getCategory().equals(Category.CREDIT))
            out = "Transfer To " + tr.getRecipient().getName() 
            + "(id = " + tr.getRecipient().getId() + ") "
            + -tr.getAmount() + " removed";
        else
            out = "Transfer From " + tr.getSender().getName() 
            + "(id = " + tr.getSender().getId() + ") "
            + tr.getAmount() + " removed";
        System.out.println(out);
        System.out.println("---------------------------------------------------------");
    }

    private void checkTransferValidity() {
        if (!mode.equals(Mode.DEV)) {
            System.err.println("You can't perform such action in production mode");
            System.out.println("---------------------------------------------------------");
            return ;
        }
        System.out.println("Check results:");
        Transaction[] unpairedTransfers = transactionsService.checkTransactionsValidity();
            //  Mike(id = 2) has an unacknowledged transfer id = 1fc852e7-914f-4bfd-913d-0313aab1ed99 from John(id =
            // 1) for 150
        for (int i = 0; i < unpairedTransfers.length; i++) {
            String out;
            if (unpairedTransfers[i].getSender().getTransactions().getTransactionById(unpairedTransfers[i].getUuid()) != null) {
                out = unpairedTransfers[i].getSender().getName() + "(id = " + unpairedTransfers[i].getSender().getId()
                    + ") has an unacknowledged transfer id = " + unpairedTransfers[i].getUuid()
                    + " To " + unpairedTransfers[i].getRecipient().getName() + "(id = " + unpairedTransfers[i].getRecipient().getId()
                    + ") for " + unpairedTransfers[i].getAmount();
            }
            else {
                out = unpairedTransfers[i].getRecipient().getName() + "(id = " + unpairedTransfers[i].getSender().getId()
                    + ") has an unacknowledged transfer id = " + unpairedTransfers[i].getUuid()
                    + " From " + unpairedTransfers[i].getSender().getName() + "(id = " + unpairedTransfers[i].getSender().getId()
                    + ") for " + unpairedTransfers[i].getAmount();
            }
            System.out.println(out);
        }
        System.out.println("---------------------------------------------------------");
    }

    private void Default() {
        System.err.println("Invalid menu choice\n---------------------------");
    }
}
