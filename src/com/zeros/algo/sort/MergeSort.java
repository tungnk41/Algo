package com.zeros.algo.sort;

public class MergeSort {

    private static void merge(int[] array, int[] left, int[] right){
        int i = 0; // index left
        int j = 0; // index right
        int k = 0; // index array

        while (i < left.length && j < right.length){
            if(left[i] <= right[j]){
                array[k++] = left[i++];
            }else{
                array[k++] = right[j++];
            }
        }

        while( i < left.length){
            array[k++] = left[i++];
        }

        while( j < right.length){
            array[k++] = right[j++];
        }
    }
    public static int[] sort(int[] array){
        int length = array.length;
        if(length<2) return array;

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for (int i = 0; i < mid; i++){
            left[i] = array[i];
        }

        for (int j = mid; j < length; j++){
            right[j - mid] = array[j];
        }

        sort(left);
        sort(right);

        merge(array,left,right);

        return array;
    }
}
