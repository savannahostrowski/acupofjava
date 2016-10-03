import java.util.Arrays;

import static java.lang.Math.abs;
import static sun.swing.MenuItemLayoutHelper.max;

public class TreesAndGraphs {
    public static void main(String[] args) {
//        Tree tree1 = new Tree(3, new Tree(4), new Tree(5));
//        Tree tree2 = new Tree(2, new Tree(1), new Tree(10));
//        Tree newTree = new Tree(3, tree1, null);
//        int[] inputarr = {5, 10, 11, 15, 20, 25};
//        Tree output = CreateBST(inputarr);
//        int[] newarr = Tree.storeInOrder(output);
//        System.out.println(Arrays.toString(newarr));

//        Tree output = Tree.CheckBalanced(newTree);

        Tree tree9 = new Tree(6, null, null);
        Tree tree8 = new Tree(3, null, null);
        Tree tree7 = new Tree(5, tree8, tree9);
        Tree tree6 = new Tree(13, null, null);
        Tree tree5 = new Tree(11, null, null);
        Tree tree4 = new Tree(25, null, null);
        Tree tree3 = new Tree(7, tree7, null);
        Tree tree2 = new Tree(12, tree5, tree6);
        Tree tree1 = new Tree(8, tree3, tree4);
        Tree newtree = new Tree (10, tree1, tree2);

        System.out.println(isBST(newtree, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    public static class Tree {
        int node;
        Tree left;
        Tree right;

        public Tree(int node, Tree left, Tree right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }

        public Tree(int node) {
            this.node = node;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return node;
        }

        public Tree getLeft() {
            return left;
        }

        public Tree getRight() {
            return right;
        }

        public void setValue(int val) {
            this.node = val;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public static void print(Tree root) {
            if (root == null) {
                return;
            }
            System.out.println(root.node + " ");

            Tree.print(root.left);
            Tree.print(root.right);
            System.out.println();

        }

        public static boolean CheckBalanced(Tree TreeInput) {
            int RightHeight;
            int LeftHeight;

            if (TreeInput == null) {
                return true;
            }

            RightHeight = TreeHeight(TreeInput.right);
            LeftHeight = TreeHeight(TreeInput.left);

            if (abs(RightHeight - LeftHeight) <= 1) {
                CheckBalanced(TreeInput.right);
                CheckBalanced(TreeInput.left);
                return true;
            }
            return false;

        }

        public static int TreeHeight(Tree input) {
            if (input == null) {
                return 0;
            }
            return 1 + max(TreeHeight(input.left), TreeHeight(input.right));
        }

        static int[] testarr = new int[6];
        static int testindex = 0;
        static int[] storeInOrder(Tree inputTree) {
            if (inputTree == null) {
                return new int[0];
            }

            storeInOrder(inputTree.getLeft());
            testarr[testindex++] = inputTree.getValue();
            storeInOrder(inputTree.getRight());
            return testarr;
        }


    }

    public static Tree CreateBST(int[] arr) {
        int middle = arr.length / 2;
        System.out.println(middle);
        Tree BSTOutput = null;

        if (arr.length == 1) {
            BSTOutput = new Tree(arr[middle], null, null);
        } else {
            if (arr.length == 0) {
                BSTOutput = null;
            } else if (middle == 1 && arr.length % 2 == 0) {
                int[] LessThanRoot = Arrays.copyOfRange(arr, 0, middle);
                System.out.println(Arrays.toString(LessThanRoot));
                BSTOutput = new Tree(arr[middle], CreateBST(LessThanRoot), null);
            } else {
                int[] LessThanRoot = Arrays.copyOfRange(arr, 0, middle - 1);
                int[] GreaterThanRoot = Arrays.copyOfRange(arr, middle, arr.length);
                BSTOutput = new Tree(arr[middle - 1], CreateBST(LessThanRoot), CreateBST(GreaterThanRoot));
            }
        }

        return BSTOutput;
    }

    public static boolean isBST(Tree input, int min, int max) {
        boolean isLeftBST = false;
        boolean isRightBST = false;

        if(input.node < min || input.node > max) {
            return false;
        }

        if (input.left != null) {
            if (input.left.node < input.node) {
                System.out.println("Left:" + Integer.toString(input.left.node) + "Current: " + input.node);
                isLeftBST = isBST(input.left, min, input.node);
            } else {
                isLeftBST = false;
            }
        } else {
            isLeftBST = true;
        }


        if (input.right != null) {
            if (input.right.node > input.node) {
                System.out.println("Right:" + Integer.toString(input.right.node) + "Current: " + input.node);
                isRightBST = input.right.node > input.node && isBST(input.right, input.node + 1, max);
            } else {
                isRightBST = false;
            }
        } else {
            isRightBST = true;
        }


        return isLeftBST && isRightBST ;
    }
}

