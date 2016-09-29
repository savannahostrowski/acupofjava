import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedList {
    public static void main(String[] args) {

        Node fourth = new Node(7, null);
        Node third = new Node(7, fourth);
        Node second = new Node(7, third);
        Node first = new Node(7, second);
        Node.printLinkedList(first);
        Node.removeDuplicates(first);
        Node.printLinkedList(first);



    }

     static class Node {
        public Node next = null;
        public int data;

        public Node(int d) {
            data = d;
        }

        public Node(int data, Node node) {
            this.data = data;
            next = node;
        }

        public void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        public static int length(Node n) {
            int length = 0;
            while (n.next != null) {
                length++;
                n = n.next;
            }
            length++;
            return length;
        }

        public static void printLinkedList(Node n) {
            ArrayList<Integer> data = new ArrayList<>();
            while (n.next != null) {
                data.add(n.data);
                n = n.next;
            }
            data.add(n.data);
            System.out.println(Arrays.toString(data.toArray()));
        }

        public static void removeDuplicates(Node n) {
            HashSet<Integer> seenData = new HashSet<>();
            Node previous = n;
            seenData.add(previous.data);
            n  = n.next;
            while (n != null) {
                if (seenData.contains(n.data)) {
                    System.out.println("first");
                    previous.next = n.next;
                    n = n.next;
                } else {
                    seenData.add(n.data);
                    System.out.println("second");
                    previous = n;
                    n = n.next;
                }
            }
        }
    }

}