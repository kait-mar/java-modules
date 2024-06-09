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
        // Transaction temp = head;
        // while (temp.getNext() != null) {
        //     temp = temp.getNext();
        // }
        tail.setNext(new Transaction(_transaction));
        tail = tail.getNext();
        size++;
    }

    public void remove(String _uuid) {
        Transaction temp = head;

        while (temp.getNext() != null) {
            if (temp.getNext().getUuid().equals(_uuid)) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return ;
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

    public Transaction  getHead() {
        return head;
    }

    public void print() {
        Transaction temp = head;
        while (temp != null){
            temp.print();
            temp = temp.getNext();
        }
    }
}
