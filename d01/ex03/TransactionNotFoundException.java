package ex03;

public class TransactionNotFoundException extends RuntimeException {
    TransactionNotFoundException(String uuid) {
        super("Cannot remove transaction uuid " + uuid + ": not found");
    }
}
