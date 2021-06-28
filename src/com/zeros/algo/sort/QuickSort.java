package com.zeros.algo.sort;

import java.util.Arrays;

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

    private static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x]= array[y];
        array[y] = temp;
    }

    private static int partition(int[] array, int left, int right){
        int pivot = left + (right-left)/2;
        int temp = 0;
        int first_high = left;

        //Swap pivot value to right
        swap(array,pivot,right);

        for(int i= left; i<right;i++){
            if(array[i]<array[right]){
                temp = array[first_high];
                array[first_high] = array[i];
                array[i] = temp;
                first_high++;
            }
        }

        swap(array,first_high,right);

        return first_high;
    }

    private static int[] sort(int[] array, int left, int right){
        if(left >= right){ //array size <= 1
            return array;
        }

        int partition = partition(array,left,right);
        sort(array,left,partition-1);
        sort(array,partition+1,right);

        return array;
    }

    public static int[] sort(int[] array){
        int left = 0;
        int right = array.length-1;

        return sort(array,left,right);
    }

}
