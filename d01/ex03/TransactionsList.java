package ex03;

public interface TransactionsList {
    public void add(Transaction _transaction);
    public Transaction remove(String _uuid);
    public Transaction[] toArray();
}
