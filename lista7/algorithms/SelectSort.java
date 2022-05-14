package algorithms;

public class SelectSort {
    public SelectSort(int[] tab){
        long start = System.currentTimeMillis();
        for (int i = 0; i < tab.length - 1; ++i) {
            int index = i;
            for(int j = i + 1; j < tab.length; ++j){
                if(tab[index] > tab[j]) index = j;
            }
            if(index != i){
               swap(tab, index, i);
            }
        }
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("SelectSort: " + elapsedTime + " ms");

        if (tab.length <= 100) {
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }

    void swap(int[] tab, int s1, int s2){
        int temp = tab[s1];
        tab[s1] = tab[s2];
        tab[s2] = temp;
    }
}
