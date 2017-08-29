package Alogorithms.tree;

public class SearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {


        BinaryNode(AnyType key) {
            this.key = key;
        }

        AnyType key;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode<AnyType> parent;
    }

    private BinaryNode<AnyType> root;


    /**
     *
     * 插入
     *
     * @param key
     */
    public void treeInsert(AnyType key) {
        // 为空时 新建一个节点
        if (root == null) {
            root = new BinaryNode<>(key);
        } else {
            BinaryNode<AnyType> y = null;
            BinaryNode<AnyType> x = root;
            BinaryNode<AnyType> z = new BinaryNode<>(key);
            int compare;
            while (x != null) {
                y = x;
                compare = z.key.compareTo(x.key);
                if (compare > 0) {
                    x = x.right;
                } else {
                    x = x.left;
                }
            }
            z.parent = y;
            compare = key.compareTo(y.key);
            if (compare > 0) {
                y.right = z;
            } else {
                y.left = z;
            }
        }

    }


    /**
     *
     * 删除节点
     *
     * @param key
     */
    public void treeDelete(AnyType key) {
        BinaryNode<AnyType> z = treeSearch(root, key);
        if (z != null) {
            if (z.left == null) {
                transPlant(z, z.right);
            } else if (z.right == null) {
                transPlant(z, z.left);
            } else {
                // 很神奇的操作
                BinaryNode<AnyType> y = treeMin(z.right);
                if (y.parent != z) {
                    transPlant(y, y.right);
                    y.right = z.right;
                    y.right.parent = y;
                }
                transPlant(z, y);
                y.left = z.left;
                y.left.parent = y;
            }
        }
    }


    /**
     *
     * 将u节点替换为v节点
     *
     * @param u
     * @param v
     */
    public void transPlant(BinaryNode<AnyType> u, BinaryNode<AnyType> v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }



    /**
     *
     * 最小
     *
     * @param root
     * @return
     */
    public BinaryNode treeMin(BinaryNode<AnyType> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    /**
     *
     * 最大
     *
     * @param root
     * @return
     */
    public BinaryNode treeMax(BinaryNode<AnyType> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }


    /**
     *
     * 查找（迭代版本）
     *
     * @param root
     * @param key
     * @return
     */
    public BinaryNode inerativeTreeSearch(BinaryNode<AnyType> root, AnyType key) {
        while (root != null || !key.equals(root.key)) {
            int compare = key.compareTo(root.key);
            if (compare > 0) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }


    /**
     *
     * 查找（递归版本）
     *
     * @param root
     * @param key
     * @return
     */
    public BinaryNode treeSearch(BinaryNode<AnyType> root, AnyType key) {
        int compare = key.compareTo(root.key);
        if (root == null || key.equals(root.key)) {
            return root;
        } else if (compare > 0) {
            return treeSearch(root.right, key);
        } else {
            return treeSearch(root.left, key);
        }
    }


    /**
     *
     * 中序遍历
     *
     * @param root
     */
    public void inOrderTreeWalk(BinaryNode root) {
        if (root != null) {
            inOrderTreeWalk(root.left);
            System.out.println(root.key);
            inOrderTreeWalk(root.right);
        }
    }
}
