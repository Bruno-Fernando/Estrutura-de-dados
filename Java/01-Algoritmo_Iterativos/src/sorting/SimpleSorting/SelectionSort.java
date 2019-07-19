package sorting.SimpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
    }

    private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {

        if (array == null)
            return false;
        if (array.length == 0)
            return false;
        if (leftIndex < 0 || rightIndex < 0)
            return false;
        if (leftIndex >= rightIndex)
            return false;
        if (rightIndex >= array.length)
            return false;

        return true;
    }
}
