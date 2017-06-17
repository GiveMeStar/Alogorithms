package Alogorithms.dynamic.programming;

import java.util.ArrayList;

/**
 * 钢条切割问题
 */
public class SteelCut {

    final static int[] p;

    static {
        p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    }

    public static void main(String[] args) {
        ArrayList<SN> arrayList = SteelCut.extendedBottomUpCutRod(10);
        arrayList.forEach(SN::toString);
//        System.out.println(SteelCut.extendedBottomUpCutRod(10));
    }

    public static ArrayList<SN> extendedBottomUpCutRod(int n) {
        ArrayList<SN> arrayList = new ArrayList();
        arrayList.add(new SN(0, 0));
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            int l = 0;
            for (int i = 1; i <= j; i++) {
                if (q < p[i] + arrayList.get(j - i).s) {
                    q = p[i] + arrayList.get(j - i).s;
                    l = i;
                }
            }
            arrayList.add(j, new SN(l, q));
        }
        return arrayList;
    }


}

class SN {

    int s;
    int n;

    public SN(int s, int n) {
        this.s = s;
        this.n = n;
    }

    public String toString() {
        System.out.println("("+ n + "," + s + ")");
        return null;
    }
}
