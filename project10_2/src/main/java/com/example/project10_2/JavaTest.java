package com.example.project10_2;

import java.util.Random;

public class JavaTest {

    public static void main() {
        int[] arrNum = new int[3];
        Random rnd2 = new Random();

        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = rnd2.nextInt(10) + 1;
            if (arrNum[i] % 2 == 0) {
                i--; break;
            }
        }
        
        for (int i = 0; i < arrNum.length; i++) {
            System.out.print(arrNum[i] + " ");
        }
    }



}
