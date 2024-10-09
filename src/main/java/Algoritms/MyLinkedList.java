package Algoritms;

public class MyLinkedList<E> {

    private int size = 0;

    private Node<E> firsNode;

    private Node<E> lastNode;

    private void linkFirst(E element) {
        final Node<E> f = firsNode;
        final Node<E> newNode = new Node<>(null, element, f);
        firsNode = newNode;
        if (f == null) {
            lastNode = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    void linkLast(E element) {
        final Node<E> l = lastNode;
        final Node<E> newNode = new Node<>(l, element, null);
        lastNode = newNode;
        if (l == null) {
            firsNode = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    protected void linkBefore(E element, Node<E> currentNode) {
        final Node<E> pred = currentNode.prev;
        final Node<E> newNode = new Node<>(pred, element, currentNode);
        currentNode.prev = newNode;
        if (pred == null) {
            firsNode = newNode;
        } else {
            currentNode.next = newNode;
        }
        size++;
     }

    public void add(E element) {
        linkLast(element);
    }

    public Object[] getString() {
        Object[] r = new Object[size];
        //List<E> r = new ArrayList<>();
        int count = 0;
        Node<E> temp = firsNode;

        for (Node<E> i = firsNode; i != null; i = i.next) {
            r[count++] = temp.getElement();
        }
        return r;
    }

    private static class Node<E> {
        E element;
        private Node<E> prev;
        private Node<E> next;

        public Node() {

        }

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
