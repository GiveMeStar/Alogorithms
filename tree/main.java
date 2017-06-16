package Alogorithms.tree;

public class main {

    public static void main(String[] args) {
//        BinarySearchTree tree = new BinarySearchTree();
//        Tree tree = new Tree();
//        int[] temp = {12,34,53,29,18,45,23,64,43,90,8,10,2,5};
//        char[] temp2 = {'G','D','M','A','F','H','Z','E'};
//        for (int i = 0; i < 8; i++) {
//            tree.insert(temp[i]);
//        }
        int x = 1; int y = 4;
        int z = x ^ y;
        String temp = Integer.toBinaryString(z);

        int num = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') num++;
        }
        System.out.print(num);
    }
}
