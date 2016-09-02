import javax.swing.*;
import java.awt.*;

public class Tree extends JPanel {
    private Node root;
    public boolean aaa = false;

    public Tree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        } else if (data < current.getData()) {
            current.setLeft(insert(current.getLeft(), data));
        } else {
            current.setRight(insert(current.getRight(), data));
        }
        return (balance(current));
    }

    public int height(Node p) {
        if (p == null) return 0;
        return p.height;
    }

    public int bfactor(Node p) {
        return height(p.right) - height(p.left);
    }

    public void fixheight(Node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        if (hl <= hr) {
            p.height = hr + 1;
        } else {
            p.height = hl + 1;
        }
    }

    public Node Rotate_right(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixheight(p);
        fixheight(q);
        return q;
    }

    public Node Rotate_left(Node q) {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixheight(q);
        fixheight(p);
        return p;
    }

    public Node balance(Node p) {
        fixheight(p);
        if (bfactor(p) == -2) {
            if (bfactor(p.left) > 0)
                p.left = Rotate_left(p.left);
            return Rotate_right(p);
        }
        if (bfactor(p) == 2) {
            if (bfactor(p.right) < 0)
                p.right = Rotate_right(p.right);
            return Rotate_left(p);
        }
        return p;
    }

    public void find(Graphics g, int f, Color blue, Color black) {
        super.paintComponent(g);
        findTree(g, root, f, 650, 30, 300, blue, black);
    }

    private void findTree(Graphics g, Node current, int f, int a, int b, int v, Color blue, Color black) {
        aaa = false;
        if ((current != null) && (current.getData() == f)) {
            g.setColor(blue);
            g.fillOval(a, b, 30, 30);
            g.setColor(black);
            String str = Integer.toString(current.getData());
            g.drawString(str, a + 10, b + 20);
            aaa = true;
        } else if (current != null) {
            if (f < current.getData()) {
                findTree(g, current.getLeft(), f, a - v, b + 70, v / 2, blue, black);
            } else {
                findTree(g, current.getRight(), f, a + v, b + 70, v / 2, blue, black);
            }
        }
        if (!aaa) {
            g.drawString("NOT FOUND", 1200, 500);
        }
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        drawTree(g, root, 650, 30, 300);
    }

    private void drawTree(Graphics g, Node current, int a, int b, int v) {
        if (current != null) {
            g.drawOval(a, b, 30, 30);
            String str = Integer.toString(current.getData());
            g.drawString(str, a + 10, b + 20);
            if (current.getLeft() != null) {
                g.drawLine(a, b + 15, a - v + 30, b + 70 + 15);
            }
            if (current.getRight() != null) {
                g.drawLine(a + 30, b + 15, a + v, b + 70 + 15);
            }
            drawTree(g, current.getLeft(), a - v, b + 70, v / 2);
            drawTree(g, current.getRight(), a + v, b + 70, v / 2);
        }
    }

    private Node remove(Node p, int k) {
        if( p == null )
            return null;
        if( k < p.data )
            p.left = remove(p.left, k);
        else if( k > p.data )
            p.right = remove(p.right, k);
        else
        {
            Node q = p.left;
            Node r = p.right;
            if( r == null )
                return q;
            Node min = findmin(r);
            min.right = removemin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }

    public void remove(int k) {
        root=remove(root, k);
    }

    public void delete(int key) {
        Node node = find(root, key);
        if (node != null) {
            Node parent = findParent(root, null, key);
            if (node.left == null) {
                if (parent != null) {
                    if (node.data < parent.data) {
                        parent.setLeft(node.right);
                    } else {
                        parent.setRight(node.right);
                    }
                } else {
                    root = node.right;
                }
            } else if (node.right == null) {
                if (parent != null) {
                    if (node.data < parent.data) {
                        parent.setLeft(node.left);
                    } else {
                        parent.setRight(node.left);
                    }
                } else {
                    root = node.left;
                }
            } else {
                Node node1 = node.right;
                Node parent1 = node;
                while (node1.left != null) {
                    parent1 = node1;
                    node1 = node1.left;
                }
                if (node1.data < parent1.data) {
                    parent1.setLeft(node1.right);
                } else {
                    parent1.setRight(node1.right);
                }
                node.setData(node1.data);
            }
        }
    }

    private Node findParent(Node node, Node parent, int key) {
        if (node == null) {
            return null;
        }
        if (node.data > key && node.left != null) {
            return findParent(node.left, node, key);
        } else if (node.data < key && node.right != null) {
            return findParent(node.right, node, key);
        } else if (node.data == key) {
            return parent;
        } else {
            return node;
        }
    }

    public Node findmin(Node p) {
        if (p == null) return null;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node removemin(Node p) {
        if (p.left == null)
            return p.right;
        p.left = removemin(p.left);
        return balance(p);
    }

    private Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.data == data)
            return current;
        return find(data < current.data ? current.left : current.right, data);
    }

    public void clearTree() {
        root = null;
    }
}
