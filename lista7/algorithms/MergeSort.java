package algorithms;

public class MergeSort {
    public MergeSort(int[] tab){
        long start = System.currentTimeMillis();

        sort(tab, 0, tab.length - 1);

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("MergeSort: " + elapsedTime + " ms");

        if (tab.length <= 100) {
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }

    void merge(int[] array, int p, int s, int k){
        int s1 = s - p + 1;
        int s2 = k - s;

        int[] lArray = new int[s1];
        int[] rArray = new int[s2];

        for(int i = 0; i < s1; ++i){
            lArray[i] = array[p + i];
        }
        for(int i = 0; i < s2; ++i){
            rArray[i] = array[s + 1 + i];
        }

        int lArrayI = 0;
        int rArrayI = 0;

        int mergedIndex = p;

        while(lArrayI < s1 && rArrayI < s2){
            if(lArray[lArrayI] <= rArray[rArrayI]){
                array[mergedIndex] = lArray[lArrayI];
                lArrayI++;
            }
            else{
                array[mergedIndex] = rArray[rArrayI];
                rArrayI++;
            }
            mergedIndex++;
        }

        while(lArrayI < s1){
            array[mergedIndex] = lArray[lArrayI];
            lArrayI++;
            mergedIndex++;
        }

        while(rArrayI < s2){
            array[mergedIndex] = rArray[rArrayI];
            rArrayI++;
            mergedIndex++;
        }
    }

    void sort(int[] array, int p, int k){
        if(p < k){
            int s = p + (k-p)/2;

            sort(array, p, s);
            sort(array, s + 1, k);

            merge(array, p, s, k);
        }
    }



}
