package Alogorithms.tree;

public class AvlTree<AnyType extends Comparable<? super AnyType>> {

    private static final int ALLOWED_IMBALANCE = 1;

    /**
     * 节点类
     * @param <AnyType>
     */
    public static class AvlNode<AnyType> {

        AvlNode(AnyType theElement) { this(theElement, null, null); }

        AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType                     element;
        AvlNode<AnyType>            left;
        AvlNode<AnyType>            right;
        int                         height;
    }

    private AvlNode<AnyType> root;

    private int height(AvlNode<AnyType> t) { return t == null ? -1 : t.height; }


    public void insert(AnyType x) { root = insert(x, root); }

    /**
     * 插入新节点
     * @param x
     * @param t
     * @return
     */
    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) return new AvlNode(x, null, null);

        int compareResult = x.compareTo( t.element );

        if (compareResult < 0 ) t.left = insert(x, t.left);
        else if (compareResult > 0) t.right = insert(x, t.right);
        else ;
        return balance(t);
    }

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) return t;

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) t = rotateWithLeftChild(t);
            else t = doubleWithLeftChild(t);
        }
        else if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) t = rotateWithRightChild(t);
            else t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.right), height(t.left)) + 1;
        return t;
    }

    /**
     * 左旋转
     * @param k2
     * @return
     */
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }


    /**
     * 右旋转
     * @param k1
     * @return
     */
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }


    /**
     * 双旋转   右-左
     * @param k3
     * @return
     */
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }


    /**
     * 双旋转   左-右
     * @param k3
     * @return
     */
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }


}
