public class Node {
    public int data;
    public Node left;
    public Node right;
    public int height;

    public Node(int data){
        this.data=data;
        left = null;
        right=null;
        height=1;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int data) {
        this.height = height;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}