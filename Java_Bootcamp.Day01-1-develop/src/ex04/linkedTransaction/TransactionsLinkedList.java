package src.ex04.linkedTransaction;

import src.ex04.trasaction.Transaction;

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
        Node newNode = new Node(transaction, null, null);
        if (size == 0) {
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
        while(current.next != null && !current.item.getIdentifier().equals(id)) {
                current = current.next;
        }
        if (current.item.getIdentifier().equals(id)) {
            if (current != first) {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == last) {
                    last = current.prev;
                }
            } else {
                first = current.next;
                if (first != null) {
                    first.prev = null;
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
        Transaction[] result = new Transaction[size];
        Node current = first;
        if (size > 0) {
            for (int i = 0; i < size && current != null; i++) {
                result[i] = current.item;
                current = current.next;
            }
        }
        return (result);
    }
}
