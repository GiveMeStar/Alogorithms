package Alogorithms;

import java.util.ArrayList;

public class LCS {
    private ArrayList LcsLength(char[] X, char[] Y){
        int[][] C = new int[X.length+1][Y.length+1];
        char[][] B = new char[X.length+1][Y.length+1];
        for (int i = 0; i < X.length+1; i++) C[i][0] = 0;
        for (int i = 0; i < Y.length+1; i++) C[0][i] = 0;
        for (int i = 1; i < X.length+1; i++) {
            for (int j = 1; j < Y.length+1; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = '#';
                } else  if(C[i - 1][j] > C[i][j - 1]){
                    C[i][j] = C[i - 1][j];
                    B[i][j] = '(';
                } else {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = ')';
                }
            }
        }
        ArrayList<char[][]> list = new ArrayList();
//        list.add(C);
        list.add(B);
        return list;
    }

    public void PrintLcs(char[][] B, char[] X, int i, int j){
        if (i == 0 || j == 0) return;
        if (B[i][j] == '#') {
            PrintLcs(B, X, i - 1, j - 1);
            System.out.println(X[i - 1]);
        } else if (B[i][j] == '(') {
            PrintLcs(B, X, i - 1, j);
        } else {
            PrintLcs(B, X, i, j - 1);
        }
    }

    public void Lcs(char[] X, char[] Y){
        ArrayList<char[][]> list = LcsLength(X, Y);
        PrintLcs(list.get(0), X, X.length, Y.length);
    }


}
