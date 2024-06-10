package ex03;

public class TransactionsLinkedList implements TransactionsList {
    private Transaction head = null;
    private Transaction tail = null;
    private int size = 0;

    public void add(Transaction _transaction) {
        if (size == 0) {
            head = new Transaction(_transaction);
            tail = head;
            size++;
            return ;
        }
        tail.setNext(new Transaction(_transaction));
        tail = tail.getNext();
        size++;
    }

    public Transaction remove(String _uuid) {
        Transaction temp = head;

        if (head.getUuid().equals(_uuid)) {
            this.head = this.head.getNext();
            size--;
            return temp;
        }
        while (temp != null && temp.getNext() != null) {
            if (temp.getNext().getUuid().equals(_uuid)) {
                Transaction ret = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                size--;
                return ret;
            }
            temp = temp.getNext();
        }
        throw new TransactionNotFoundException(_uuid);
    }

    public Transaction[] toArray() {
        Transaction[] array = new Transaction[size];
        Transaction temp = head;

        int i = 0;
        while (temp != null){
            array[i++] = temp;
            temp = temp.getNext();
        }
        return (array);
    }

    public Transaction getTransactionById(String uuid) {
        Transaction temp = head;

        while (temp != null) {
            if (temp.getUuid().equals(uuid)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public Transaction  getHead() {
        return head;
    }

    public int      getSize() { return this.size; }

    public void print() {
        Transaction temp = head;
        while (temp != null){
            temp.print();
            temp = temp.getNext();
        }
    }
}
