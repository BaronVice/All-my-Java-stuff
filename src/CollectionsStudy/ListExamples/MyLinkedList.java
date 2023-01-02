package CollectionsStudy.ListExamples;

import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(int value){
        if (head == null){
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();

            temp.setNext(new Node(value));
        }

        size++;
    }

    public int get(int index){
        if (index < 0)
            index += size;

        Objects.checkIndex(index, size);

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();

        return temp.getValue();
    }

    public void remove(int index){
        if (index < 0)
            index += size;

        Objects.checkIndex(index, size);

        if (index == 0)
            removeHead();
        else
            removeInList(index);

        size--;
    }
    private void removeHead(){
        head = head.getNext();
    }
    private void removeInList(int index){
        Node temp = head;
        for (int i = 1; i < index; i++)
            temp = temp.getNext();

        temp.setNext(temp.getNext().getNext());
    }

    public String toString(){
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while(temp != null){
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    private static class Node{
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
