package org.example.DeletedPieces;

public class MyList<T> {

    private int size;
    private Node<T> head;

    public MyList() {
        size = 0;
        head = null;
    }

    public void addHead(T element) {
        Node<T> aux = new Node<>(element);
        aux.setNext(head);
        head = aux;
        size++;
    }

    public void addTail(T element) {

        if (head == null)
            addHead(element);
        else {

            Node<T> aux = head;
            while (aux.getNext() != null)
                aux = aux.getNext();


            aux.setNext(new Node<T>(element));
            size++;
        }
    }

    public T remove(int index) {

        if (index >= size || index < 0)
            return null;

        if (index == 0) {
            T info = head.info;
            head = head.getNext();
            size--;
            return info;
        }

        Node<T> aux = head;
        while (--index > 0)
            aux = aux.getNext();

        T info = aux.getNext().info;

        aux.setNext(aux.getNext().getNext());
        size--;
        return info;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index fuera de rango: " + index);

        Node<T> node = head;
        while (index-- > 0)
            node = node.next;

        return node.info;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return "size: " + size + "\n" + ((head == null) ? "[]" : "[" + head);
    }

    public class Node<T> {

        private T info;
        private Node<T> next;

        Node(T info) {
            this.info = info;
            this.next = null;
        }

        public T getInfo() {
            return info;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> node) {
            this.next = node;
        }

        public String toString() {
            return info + ((next != null) ? " " + next : "]");
        }
    }
}