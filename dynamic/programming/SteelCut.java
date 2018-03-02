package Alogorithms.dynamic.programming;

import java.util.ArrayList;

/**
 * 钢条切割问题
 */
public class  SteelCut {

    final static int[] p;

    static {
        p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    }

    public static void main(String[] args) {
        ArrayList<SN> arrayList = SteelCut.extendedBottomUpCutRod(20);
        arrayList.forEach(SN::toString);
//        System.out.println(SteelCut.extendedBottomUpCutRod(10));
    }

    /**
     * 自底向上法
     * 将子问题按规模排序，按由小至大的顺序进行求解
     * @param n
     * @return
     */
    public static ArrayList<SN> extendedBottomUpCutRod(int n) {
        ArrayList<SN> arrayList = new ArrayList();
        arrayList.add(new SN(0, 0));
        //按升序求解规模为j的子问题
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            int l = 0;
            //在以求的规模中寻找最优解 并记录
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


    public static int CutRod(int[] p, int n, int[] r) {
        if (r[n] > Integer.MIN_VALUE) {
            return r[n];
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + CutRod(p, n - 1 , r));
        }
        r[n] = q;
        return q;
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
