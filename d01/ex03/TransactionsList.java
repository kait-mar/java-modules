package ex03;

public interface TransactionsList {
    public void add(Transaction _transaction);
    public void remove(String _uuid);
    public Transaction[] toArray();
}
