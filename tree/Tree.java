package Alogorithms.tree;

public class Tree<AnyType extends Comparable<? super AnyType>> {

    private static class Node<AnyType> {

        Node(AnyType theElement, Node<AnyType> parent, Node<AnyType> left, Node<AnyType> right){
            element = theElement;
            parent = parent;
            left = left;
            right = right;
        }

        AnyType element;
        Node<AnyType> parent;
        Node<AnyType> left;
        Node<AnyType> right;
    }

    private Node<AnyType> root;

    public void makeEmpty() { root = null; }
    public boolean isEmpty() { return root == null; }
    public void insert(AnyType x) { root = treeInsert(x, root); }

    public Node<AnyType> treeSearch(Node<AnyType> x, AnyType k) {
        if (x == null || k == x.element) return x;
        int temp = k.compareTo(x.element);
        if (temp < 0) return treeSearch(x.left, k);
        else return treeSearch(x.right, k);
    }

    public Node<AnyType> treeMinMum(Node<AnyType> x) {
        while (x.left != null) x = x.left;
        return x;
    }

    public Node<AnyType> treeMaxMum(Node<AnyType> x) {
        while (x.right != null) x = x.right;
        return x;
    }

    public Node<AnyType> treeSuccessor(Node<AnyType> x) {
        if (x.right != null) return treeMinMum(x.right);
        Node<AnyType> y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public Node<AnyType> treeInsert(AnyType z, Node<AnyType> T) {
        Node<AnyType> y = null;
        Node<AnyType> x = T;
        while (x != null) {
            y = x;
            int temp = z.compareTo(x.element);
            if (temp < 0) x = x.left;
            else x = x.right;
        }
        int temp = 0;
        if (y != null) {
             temp = z.compareTo(y.element);
        }
        if (y == null) return new Node<>(z, null , null , null);
        else if (temp < 0) y.left = new Node<>(z, y, null, null);
        else y.right = new Node<>(z, y, null, null);
        while (y.parent != null) {
            y = y.parent;
        }
        T = y;
        return T;
    }



}
