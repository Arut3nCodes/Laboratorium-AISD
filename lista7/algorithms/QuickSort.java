package algorithms;

import java.util.Random;

public class QuickSort {

    public QuickSort(int[] tab){
        long start = System.currentTimeMillis();

        quickSort(tab, 0, tab.length);

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("QuickSort: " + elapsedTime + " ms");

        if (tab.length <= 100) {
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }

     void swap(int[] tab, int i, int j)
    {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

     int partition(int[] tab, int nFrom, int nTo)
    {
        Random random = new Random()    ;
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(tab, nFrom, rnd);
        int value = tab[nFrom];
        int idxBigger = nFrom + 1, idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && tab[idxBigger] <= value)
                idxBigger++;
            while (tab[idxLower] > value)
                idxLower--;
            if (idxBigger < idxLower)
                swap(tab, idxBigger, idxLower);
        } while (idxBigger < idxLower);
        swap(tab, idxLower, nFrom);
        return idxLower;
    }

    void quickSort(int[] tab, int low, int high)
    {
        if (high - low > 1) {
            int partition = partition(tab, low, high);
            quickSort(tab, low, partition);
            quickSort(tab, partition + 1, high);
        }
    }
}
