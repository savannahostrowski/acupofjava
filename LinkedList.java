import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedList {
    public static void main(String[] args) {

        Node fifth = new Node(1, null);
        Node fourth = new Node(2, fifth);
        Node third = new Node(3, fourth);
        Node second = new Node(3, third);
        Node first = new Node(1, second);

        Node third1 = new Node(6, null);
        Node second1 = new Node(1, third1);
        Node first1 = new Node(7, second1);


        Stack stk1 = new Stack ();
        stk1.push(5);
        stk1.push(3);
        stk1.push(1);

        Stack newstk = AscendingStack.sort(stk1);



        System.out.println(newstk.pop());
        System.out.println(newstk.pop());
        System.out.println(newstk.pop());
////
//
//        Stack stk2 = new Stack();
//        stk2.push(2);
//        stk2.push(4);
//        stk2.push(6);
//        boolean val = stk2.isEmpty();
//        System.out.println(val);



        //System.out.println(stackofstk.toString());


//        SetOfStacks stackeg = new SetOfStacks();
//        stackeg.push(5);
//        stackeg.push(3);
//        stackeg.push(1);
//        stackeg.push(2);
//        stackeg.push(7);
//        stackeg.push(10);


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

         public static Node reverseAdd(Node L1, Node L2) {
             int num1 = LLToNumber(L1);
             System.out.println(num1);
             int num2 = LLToNumber(L2);
             System.out.println(num2);

             int sum = num1 + num2;
             Node finalLL = null;

             while(sum > 0) {
                 int digit = sum % 10;
                 if (finalLL == null) {
                     finalLL = new Node (digit, null);
                 } else {
                     finalLL.appendToTail(digit);
                 }
                 sum /= 10;
             }
             return finalLL;
         }

         public static int LLToNumber (Node n) {
             int factor = 1;
             int sum = 0;
             while (n != null) {
                 int temp = n.data * factor;
                 sum += temp;
                 factor *= 10;
                 n = n.next;
             }
             return sum;
         }

//         public static boolean isPalindrome(Node n) {
//             Stack<Integer> stack = new Stack<>();
//             Node temp = n;
//             //creates stack
//             while (n != null) {
//                 stack.push(n.data);
//                 n = n.next;
//             }
//             System.out.println(Arrays.toString(stack.toArray()));
//
//             while (temp != null) {
//                 int elem = stack.pop();
//                 if (elem != temp.data) {
//                     return false;
//                 }
//                 temp = temp.next;
//             }
//             return true;
//         }
    }

    // ----- STACKS AND QUEUES -------

    static class Stack {
        Node top;
        int pop() {
            if (top != null) {
                int item = top.data;
                top = top.next;
                return item;
            }
            return -1;
        }

        void push(int item) {
            Node t = new Node(item, top);
            top = t;
        }

        int peek() {
            return top.data;
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    static class StackOfStacks {

        public Stack next = null;
        public Stack top;

        public StackOfStacks(Stack stk) {
            top = stk;
        }

        public StackOfStacks(Stack top, Stack nxt) {
            this.top = top;
            next = nxt;
        }

        Stack popStack() {
            if (top != null) {
                Stack stk = top;
                top = next;
                return top;
            }
            return null;
        }


        void pushStack(Stack stk) {
            Stack temp = top;
            top = stk;
            next = temp;
        }

        Stack peek() {
            return top;
        }

        @Override
        public String toString() {
            return "StackOfStacks{" +
                    "next=" + next +
                    ", top=" + top +
                    '}';
        }
    }

    static class SetOfStacks {
        int maxSize;  //tells us what the max size of a stack should be
        Stack currentStack = new Stack();
        StackOfStacks listOfStacks = new StackOfStacks(currentStack, null);
        int currentLength = 0;

        public SetOfStacks(int maxSize) {
            this.maxSize = maxSize;
        }

        void pushElem(int elem) {
            if (currentLength < maxSize) {
                currentStack.push(elem);
                currentLength++;
            } else {
                Stack newstack = new Stack();
                newstack.push(elem);
                listOfStacks.pushStack(newstack);
                currentStack = newstack;
                currentLength = 1;
            }
        }
         int popElem() {
             if (currentLength == 0) {
                 currentStack = listOfStacks.popStack();
                 currentLength = maxSize;
             }
             currentLength--;
             return currentStack.pop();
         }

        int peek() {
            return currentStack.peek();
        }
    }

   static class AscendingStack {
        Stack stk = new Stack();

       public static Stack sort (Stack stk) {
           Stack temp = new Stack();
           while (!stk.isEmpty()) {
               int tmp = stk.pop();
               while(!temp.isEmpty() && tmp < temp.peek()) {
                   stk.push(temp.pop());
               }
               temp.push(tmp);
           }
           return temp;
       }
    }
}