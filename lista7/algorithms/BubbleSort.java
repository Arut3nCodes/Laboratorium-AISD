package algorithms;

import java.lang.System;

public class BubbleSort {
    public BubbleSort(int[] tab){
        long start = System.currentTimeMillis();
        int temp;
        for(int i = 0; i < tab.length; i++){
            // int check = 0;
            for(int j = 0; j < tab.length - i - 1; j++){
                if(tab[j] > tab[j+1]){
                    temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                   // check++;
                }
            }
           // if (check == 0) break;
        }

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("BubbleSort: " + elapsedTime + " ms");

        if(tab.length <= 100){
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }
}
