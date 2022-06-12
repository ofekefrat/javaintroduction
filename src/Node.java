public class Node {
    private int _number;
    private Node _leftSon, _rightSon;

    //constructor
    public Node(int number) {
        this._number = number;
        this._leftSon = null;
        this._rightSon = null;
    }

    public int getNumber() {
        return _number;
    }

    public Node getLeftSon() {
        return _leftSon;
    }

    public Node getRightSon() {
        return _rightSon;
    }

    public void setNumber(int number) {
        this._number = number;
    }

    public void setLeftSon(Node node) {
        this._leftSon = node;
    }

    public void setRightSon(Node node) {
        this._rightSon = node;
    }

    public boolean isLeaf() {
        return (this.getLeftSon() == null && this.getRightSon() == null);
    }

    public static boolean search(Node root, int num) {
        if (root == null) return false;

        if (root.getNumber() == num) return true;
        return search(root.getLeftSon(), num) || search(root.getRightSon(), num);
    }

    public static int sum(Node node) {
        if (node == null) return 0;
        return (node.getNumber() + sum(node.getLeftSon()) + sum(node.getRightSon()));
    }

    //TODO test
    public static int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.getRightSon()) + size(node.getLeftSon());
    }

    public static int countLeaves(Node node) {
        if (node == null) return 0;

        if ((node.getLeftSon() == null) &&
                (node.getRightSon() == null)) return 1;

        return countLeaves(node.getLeftSon()) +
                countLeaves(node.getRightSon());
    }

    public static boolean allRootsGreater(Node t) {
        if (t.isLeaf()) return true;
        if (t.getLeftSon() == null)
            return (t.getNumber() > t.getRightSon().getNumber())
                    && allRootsGreater(t.getRightSon());
        if (t.getRightSon() == null)
            return (t.getNumber() > t.getLeftSon().getNumber())
                    && allRootsGreater(t.getLeftSon());
        return (t.getNumber() > t.getLeftSon().getNumber())
                && (t.getNumber() > t.getRightSon().getNumber())
                && allRootsGreater(t.getLeftSon())
                && allRootsGreater(t.getRightSon());
    }

    public static int maxNode(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int currentMax = Math.max(maxNode(root.getLeftSon()), maxNode(root.getRightSon()));
        return Math.max(root.getNumber(), currentMax);
    }

    public static int maxLeaf(Node n) {
        if (n == null) return 0;
        if (n.isLeaf()) return n.getNumber();

        if (n.getRightSon() == null) return (maxLeaf(n.getLeftSon()));
        if (n.getLeftSon() == null) return (maxLeaf(n.getRightSon()));

        int a = maxLeaf(n.getLeftSon());
        int b = maxLeaf(n.getRightSon());

        return Math.max(a, b);
    }

    public static void printPreOrder(Node root) {
        if (root != null) {
            System.out.println(root.getNumber() + " ");
            printPreOrder(root.getLeftSon());
            printPreOrder(root.getRightSon());
        }
    }

    public static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeftSon());
            System.out.println(root.getNumber() + " ");
            printInOrder(root.getRightSon());
        }
    }

    public static void printPostOrder(Node root) {
        if (root != null) {
            printPostOrder(root.getLeftSon());
            printPostOrder(root.getRightSon());
            System.out.println(root.getNumber() + " ");
        }
    }


    // BINARY SEARCH TREE

    public static boolean SearchInBST(Node root, int target) {
        if (root == null) return false;
        if (root.getNumber() == target) return true;

        if (target < root.getNumber()) return SearchInBST(root.getLeftSon(), target);
        return SearchInBST(root.getRightSon(), target);
    }

    public static void insertInBST(Node node, int num) {
        Node temp = new Node(num);
        if (node == null) {
            node = temp;
            return;
        }
        if (num < node.getNumber()) {
            if (node.getLeftSon() == null)
                node.setLeftSon(temp);

            else insertInBST(node.getLeftSon(), num);
        }
        else if (num > node.getNumber()) {
            if (node.getRightSon() == null)
                node.setRightSon(temp);

            else insertInBST(node.getRightSon(), num);
        }
    }

    public static int maxNodeBST(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.getRightSon() == null) return root.getNumber();
        return maxNodeBST(root.getRightSon());
    }

    public static int minNodeBST(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.getLeftSon() == null) return root.getNumber();
        return maxNodeBST(root.getLeftSon());
    }

}
