package src.ex05.linkedTransaction;

import src.ex05.trasaction.Transaction;
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
        Node newNode = new Node(transaction, last, null);
        last = newNode;
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public boolean removeTransaction(UUID id) {
        Node current = first;
        while (current != null && !current.item.getIdentifier().equals(id)) {
            current = current.next;
        }
        if (current == null) {
            throw new TransactionNotFoundException("There is no transaction with Id = " + id);
        }
        Node nextNode = current.next;
        if (current != first) {
            current.prev.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = current.prev;
            }
            if (current == last) {
                last = current.prev;
            }
        } else {
            first = nextNode;
            if (first != null) {
                first.prev = null;
            }
        }
        size--;
        return true;
    }


    @Override
    public Transaction[] toArray() {
        Transaction[] result;
        Node current = first;
        if (size > 0) {
            result = new Transaction[size];
            for (int i = 0; i < size && current != null; i++) {
                result[i] = current.item;
                current = current.next;
            }
            return result;
        }
        return null;
    }

    @Override
    public Transaction findTransaction(UUID id) {
        for (Transaction t : this.toArray()) {
            if (t.getIdentifier().equals(id)) {
                return t;
            }
        }
        return null;
    }
}
