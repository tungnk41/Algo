package com.zeros.algo.search;

public class UpperBound {
    public static int search(int[] array, int x){
        int left = 0;
        int right = array.length-1;
        int mid = 0;

        while (left<right){
            mid = (left+right)/2;
            if(array[mid] <= x){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}
