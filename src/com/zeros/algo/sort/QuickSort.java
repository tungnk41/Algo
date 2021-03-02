package com.zeros.algo.sort;

public class QuickSort {

    /*
    - pivot position will separate array to 2 part, part 1 : smaller than pivot, part 2: larger than pivot.
    by finding pivot position for each part, array will be sorted
    0 2 1 4       5      6 9 8 7
    ( data < pv)  pv    (data > pv)

    Time : O(nlog(n)) averager
    Space: (log(n))
    Not stable

     */
    private static int partition(int[] array, int left, int right){
        int pivot = array[right];

        for(int i= left; i<right;i++){
            if(array[i]<pivot){
                int temp = array[left];
                array[left] = array[i];
                array[i] = temp;
                left++;
            }
        }
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        return left;
    }

    private static int[] sort(int[] array, int left, int right){
        int partition = partition(array,left,right);

        if(partition - 1 > left){
            sort(array,left,partition-1);
        }
        if (partition + 1 < right){
            sort(array,partition+1,right);
        }

        return array;
    }

    public static int[] sort(int[] array){
        int left = 0;
        int right = array.length-1;

        return sort(array,left,right);
    }

}
