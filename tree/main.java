package Alogorithms.tree;

import java.util.Date;
import java.util.EnumSet;

public class main {

    public static void main(String[] args) {
//        SearchTree tree = new SearchTree();
//
//        int[] temp = {12,34,53,29,18,45,23,6,64,43,90,8,10,2,5};
//        for (int i = 0; i < 9; i++) {
//            tree.treeInsert(temp[i]);
//        }
//        tree.treeDelete(64);
//        tree.treeDelete(12);

        Long date = new Date().getTime();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        System.out.println(new Date().getTime() - date);

    }
}
