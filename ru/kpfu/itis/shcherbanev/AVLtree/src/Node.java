public class Node {

    int value;
    int height;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.height = 1;
    }

    @Override
    public String toString() {
        return value + " " + height;
    }
}