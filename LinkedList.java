import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedList {
    public static void main(String[] args) {

        Node fifth = new Node(1, null);
        Node fourth = new Node(7, fifth);
        Node third = new Node(9, fourth);
        Node second = new Node(7, third);
        Node first = new Node(7, second);
//        Node.printLinkedList(first);
//        Node.removeDuplicates(first);
//        Node.printLinkedList(first);
//        Node.printNode(Node.findKth(first, 1));
        Node.printLinkedList(Node.partition(first, 3));

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

        public static void printNode(Node n) {
            System.out.println(n.data);
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

        public static Node findKth(Node n, int k) {
            if (k > length(n)) {
                return null;
            }
            int counter = 0;
            int length = length(n);
            while (n.next != null) {
                int distanceFromEnd = length - counter - 1;
                if (distanceFromEnd == k) {
                    return n;
                }
                n = n.next;
                counter++;
            }
            if ((length(n) - counter) == k) {
                return n;
            }

            return null;
        }

         public static Node appendList(Node L1, Node L2) {
             while (L1.next != null) {
                 L1 = L1.next;
             }
             L1.next = L2;
             return L1;
         }

         public static Node partition(Node n, int x) {

            Node storeLarger = null;
            Node storeSmaller = null;

            while(n != null) {
                if (n.data < x) {
                    if (storeSmaller == null) {
                        storeSmaller = new Node(n.data, null);
                    } else {
                        storeSmaller.appendToTail(n.data);
                    }
                } else {
                    if (storeLarger == null) {
                        storeLarger = new Node(n.data, null);
                    } else {
                        storeLarger.appendToTail(n.data);
                    }
                }
                n = n.next;
            }


            appendList(storeSmaller, storeLarger);
            return storeSmaller;
        }
    }

}