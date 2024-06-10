package ex04;

public class IllegalTransactionException extends RuntimeException {
    public IllegalTransactionException(int id) {
        super(" User with Id " + id + " has inssuficient balance to perform this transaction");
    }
}
