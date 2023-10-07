package edu.cscc;

public class LinkedList<E> {
    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    public void addFirst(E content) {
        Node<E> ptr = head;
        head = new Node<>(content, ptr);
    }

    public void addLast(E content) {
        Node<E> last = new Node<>(content, null);
        if (head == null) {
            head = last;
        } else {
            Node<E> ptr = head;
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(last);
        }
    }

    public boolean deleteFirst() {
        if (head == null) {
            return false;
        } else {
            head = head.getNext();
            return true;
        }
    }

    public boolean deleteLast() {
        if (head == null) {
            return false;
        } else if (head.getNext() == null) {
            head = null;
            return true;
        } else {
            Node<E> ptr = head;
            while (ptr.getNext().getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(null);
            return true;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if (head == null) {
            str.append("<empty>");
        } else {
            Node<E> ptr = head;
            str.append("(");
            str.append(ptr.getContent().toString());
            str.append(")");
            while (ptr.getNext() != null) {
                str.append("->");
                ptr = ptr.getNext();
                str.append("(");
                str.append(ptr.getContent().toString());
                str.append(")");
            }
        }
        return str.toString();
    }
}
