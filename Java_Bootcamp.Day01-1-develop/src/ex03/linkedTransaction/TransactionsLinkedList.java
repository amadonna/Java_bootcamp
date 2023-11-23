package src.ex03.linkedTransaction;
import src.ex03.trasaction.Transaction;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private int size;
    private Node first;
    private Node last;
    //LinkedList<int> a;
    public TransactionsLinkedList() {
        first = null;
        last = null;
        size = 0;
    }


    private static class Node {
        Transaction item;
        Node prev;
        Node next;
        Node(Transaction data, Node prev, Node next) {
            this.item = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (size == 0) {
            Node newNode = new Node(transaction, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node temp = new Node(transaction, last, null);
            last.next = temp;
            last = temp;
        }
        size++;
    }

    @Override
    public boolean removeTransaction(UUID id) {
        Node current = first;
        boolean find = false;
        while(current.next != null && !find) {
            if (current.item.getIdentifier().equals(id)) {
                find = true;
            }
            else {
                current = current.next;
            }
        }
        if (find) {
            if (current == first) {
                first = current.next;
                if (first != null) {
                    first.prev = null;
                }
            } else {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == last) {
                    last = current.prev;
                }
            }
            size--;
        }
        else {
            throw new TransactionNotFoundException("There is not transaction with Id = " + id);
        }
        return true;
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] result = null;
        Node current = first;
        if (size > 0) {
            result = new Transaction[size];
            for (int i = 0; i < size && current != null; i++) {
                result[i] = current.item;
                current = current.next;
            }
        }
        return (result);
    }
}
