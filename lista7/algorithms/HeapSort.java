package algorithms;

public class HeapSort {

    public HeapSort(int[] tab) {
        long start = System.currentTimeMillis();

        sort(tab);

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("HeapSort: " + elapsedTime + " ms");

        if (tab.length <= 100) {
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        }
    }

        public void sort(int tab[])
        {
            int len = tab.length;

            for (int i = len/2 - 1; i >= 0; i--) {
                heapify(tab, len, i);
            }

            for (int i = len - 1; i > 0; i--) {
                int temp = tab[0];
                tab[0] = tab[i];
                tab[i] = temp;
                heapify(tab, i, 0);
            }
        }

        void heapify(int tab[], int n, int i)
        {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && tab[left] > tab[largest])
                largest = left;

            if (right < n && tab[right] > tab[largest])
                largest = right;

            if (largest != i) {
                int swap = tab[i];
                tab[i] = tab[largest];
                tab[largest] = swap;
                heapify(tab, n, largest);
            }
        }
}
