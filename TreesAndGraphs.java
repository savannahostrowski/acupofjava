import java.util.Arrays;

import static java.lang.Math.abs;
import static sun.swing.MenuItemLayoutHelper.max;

public class TreesAndGraphs {
    public static void main(String[] args) {
        Tree tree1 = new Tree(3, new Tree(4), new Tree(5));
        Tree tree2 = new Tree(2, new Tree(1), new Tree(10));
        Tree newTree = new Tree(3, tree1, null);
        int[] inputarr = {5, 10, 11, 15, 20, 25};
        Tree output = CreateBST(inputarr);
        int[] newarr = Tree.storeInOrder(output);
        System.out.println(Arrays.toString(newarr));

//        Tree output = Tree.CheckBalanced(newTree);

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
}

