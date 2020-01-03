package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {

        if(leftIndex == rightIndex)
            return;
        else{
            int metade = ( leftIndex + rightIndex ) / 2 ;

            sort(array, leftIndex, metade);
            sort(array, metade + 1 , rightIndex);

            merge(array, leftIndex, metade,rightIndex);
        }

    }

    private void merge(T[] array, int leftIndex, int metade, int rightIndex) {
        T[] aux = Arrays.copyOfRange(array, leftIndex, rightIndex);     //rightindex + 1 se der problema

        int i = leftIndex;
        int j = metade;

        for (int k = leftIndex; k < rightIndex; k++) {

            if(i == metade)
                array[k] = aux[j++];

            else if(j == rightIndex)
                array[k] = aux[i++];

            else if(aux[i].compareTo(aux[j]) <= 0)
                array[k] = aux[i++];

            else
                array[k] = aux[j];

        }

    }

}
