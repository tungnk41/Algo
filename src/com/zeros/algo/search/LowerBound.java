package com.zeros.algo.search;

public class LowerBound {
    public static int search(int[] array, int x){
        int left = 0;
        int right = array.length-1;
        int mid = 0;

        while (left<right){
            mid = (left+right)/2;
            if(x <= array[mid]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }
}
