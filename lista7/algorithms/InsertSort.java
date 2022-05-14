package algorithms;

public class InsertSort {
    public InsertSort(int[] tab){
        long start = System.currentTimeMillis();
        for(int i = 0; i < tab.length; i++){
            int klucz = tab[i];
            int j = i - 1;

            while(j >= 0 && klucz < tab[j]){
             tab[j+1] = tab[j];
             j = j - 1;
            }

            tab[j+1] = klucz;
        }

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("InsertionSort: " + elapsedTime + " ms");

        if(tab.length <= 100){
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }
}
