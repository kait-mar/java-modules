package ex04;
import ex03.Transaction;
import ex03.User;

public class Program {
    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();
    
        for (int i = 1; i < 5; i++) {
            transactionsService.addUser(new User("Person_" + i, i + 512));
        }
        System.out.println("initiale balance for user id (" + 1 + ") is "+ transactionsService.retrieveUserBalance(1));
        System.out.println("-----------");

        transactionsService.createTransaction(1, 2, 124);
        transactionsService.createTransaction(3, 1, 15);
        transactionsService.createTransaction(4, 1, 80);
        Transaction[] trs = transactionsService.retrieveUserTransactions(1);
        Transaction[] tr2 = transactionsService.retrieveUserTransactions(3);
        for (int i = 0; i < trs.length; i++) {
            trs[i].print();
        }
        System.out.println("-----------");
        tr2[0].print();
        System.out.println("-----------");
        System.out.println("balance for user id (" + 1 + ") is "+ transactionsService.retrieveUserBalance(1));
        System.out.println("-----------");
        transactionsService.removeuserTransaction(1, trs[1].getUuid());
        // trs = transactionsService.retrieveUserTransactions(1);
        // transactionsService.removeuserTransaction(1, trs[1].getUuid());
        trs = transactionsService.retrieveUserTransactions(1);
        System.out.println("after removing a transaction for user id " + 1);
        for (int i = 0; i < trs.length; i++) {
            trs[i].print();
        }
        System.out.println("-------------");
        System.out.println("CHECKING TRANSACTIONS VALIDITY......");
        Transaction[] invalid = transactionsService.checkTransactionsValidity();
        for (int i = 0; i < invalid.length; i++) {
            invalid[i].print();
        }
        System.out.println("-------------");
        System.out.println("Trying to perform a transaction exceeding user balance .......");

        transactionsService.createTransaction(4, 1, 1500);

    }
};
