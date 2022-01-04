package com.zeros.algo.sort;

public class InsertionSort {

    public static int[] sort(int[] array){
        if(array.length < 2) return array;

        for(int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i;
            while(j > 0 && array[j-1] > current){
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;
        }

        return array;
    }
}
