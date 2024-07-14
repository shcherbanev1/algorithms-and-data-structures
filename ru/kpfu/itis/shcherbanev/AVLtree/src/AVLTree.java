public class AVLTree {

    private Node root;

    private int operationCounter;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        insertR(root, value);
    }

    public Node search(int value) {
        return searchR(root, value);
    }

    public void delete(int value) {
        deleteR(root, value);
    }


    private int getHeight(Node node) {
        operationCounter++;
        if (node == null) return 0;
        return node.height;
    }

    private int getBalance(Node node) {
        operationCounter++;
        return getHeight(node.right) - getHeight(node.left);
    }

    private void updateHeight(Node node) {
        operationCounter++;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private Node rotateRight(Node a) {
        operationCounter++;
        Node b = a.left;
        a.left = b.right;
        b.right = a;
        if (root == a) {
            root = b;
        }
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    private Node rotateLeft(Node a) {
        operationCounter++;
        Node b = a.right;
        a.right = b.left;
        b.left = a;
        if (root == a) {
            root = b;
        }
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    private Node balanceNode(Node a) {
        operationCounter++;
        updateHeight(a);
        if (getBalance(a) == 2) {
            if (getBalance(a.right) < 0) {
                a.right = rotateRight(a.right);
            }
            return rotateLeft(a);
        }
        if (getBalance(a) == -2) {
            if (getBalance(a.left) > 0) {
                a.left = rotateLeft(a.left);
            }
            return rotateRight(a);
        }
        return a;
    }

    private Node insertR(Node p, int value) {
        operationCounter++;
        if (p == null) return new Node(value);
        if (value < p.value) {
            p.left = insertR(p.left, value);
        } else {
            p.right = insertR(p.right, value);
        }
        return balanceNode(p);
    }

    private Node searchR(Node node, int value) {
        operationCounter++;
        if (node == null || node.value == value) {
            return node;
        }
        if (value < node.value) {
            return searchR(node.left, value);
        } else {
            return searchR(node.right, value);
        }
    }

    private Node findMin(Node p) {
        operationCounter++;
        if (p.left == null) return p;
        return findMin(p.left);
    }

    private Node deleteR(Node node, int value) {
        operationCounter++;
        if (node == null) {
            return node;
        }

        if (value < node.value) {
            node.left = deleteR(node.left, value);
        } else if (value > node.value) {
            node.right = deleteR(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node newChild = findMin(node.right);
            node.value = newChild.value;

            node.right = deleteR(node.right, newChild.value);
        }
        return balanceNode(node);
    }

    @Override
    public String toString() {
        return printR(root);
    }

    private String printR(Node node) {
        if (node == null) {
            return "";
        }
        String leftStr = printR(node.left);
        String rightStr = printR(node.right);
        return leftStr + node.value + " " + rightStr;
    }

    public int getOperationCounter() {
        return operationCounter;
    }

    public void setOperationCounter(int operationCounter) {
        this.operationCounter = operationCounter;
    }

    public Node getRoot() {
        return root;
    }

}
