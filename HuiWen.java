package Alogorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class HuiWen {

    public int[][] LcsLength(char[] X, char[] Y){
        int[][] C = new int[X.length+1][Y.length+1];
        for (int i = 0; i < X.length+1; i++) C[i][0] = 0;
        for (int i = 0; i < Y.length+1; i++) C[0][i] = 0;
        for (int i = 1; i < X.length+1; i++) {
            for (int j = 1; j < Y.length+1; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else  if(C[i - 1][j] > C[i][j - 1]){
                    C[i][j] = C[i - 1][j];
                } else {
                    C[i][j] = C[i][j - 1];
                }
            }
        }
        return C;
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] string = s.toCharArray();
        char[] tmp = new char[string.length];
        for (int i = 0; i < string.length/2; i++) {
            tmp[string.length - i - 1] = string[i];
            tmp[i] = string[string.length - i - 1];
        }
        HuiWen hui = new HuiWen();
        int[][] C = hui.LcsLength(string, tmp);
        System.out.print(string.length - C[string.length][string.length]);
    }
}
