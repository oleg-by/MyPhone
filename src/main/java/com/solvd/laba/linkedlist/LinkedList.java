package com.solvd.laba.linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private static int size = 0;

    public void addFirst(T t) {
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
        size++;
    }

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            size++;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(t);
        size++;
    }

    public int get(T t) {
        if (head == null) {
            return -1;
        }
        if (head.value == t) {
            return 0;
        }
        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            ++result;
            if (currentNode.next.value == t) {
                return result;
            }
            currentNode = currentNode.next;
        }

        return -1;
    }

    public void remove(T t) {
        if (head == null) {
            return;
        }
        if (head.value == t) {
            head = head.next;
            size--;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == t) {
                currentNode.next = currentNode.next.next;
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
