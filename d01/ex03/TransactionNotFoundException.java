package ex03;

public class TransactionNotFoundException extends RuntimeException {
    TransactionNotFoundException(String uuid) {
        super(" Cannot find transaction with this id: " + uuid);
    }
}
