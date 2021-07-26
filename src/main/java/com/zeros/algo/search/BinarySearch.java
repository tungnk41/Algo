package com.zeros.algo.search;

public class BinarySearch {

    private static int  search(int[] array, int left, int right, int x){
        if(right > left){
            int mid = left + (right - left)/2;
            if (array[mid] == x){
                return mid;
            }
            if(array[mid] > x){
                return search(array,left,mid-1,x);
            }else{
                return search(array,mid+1,right,x);
            }
        }

//        while(left<right){
//            int mid =left + (right - left)/2;
//            if(array[mid] == x){
//                return mid;
//            }
//            if(array[mid] < x){
//                left = mid + 1;
//            }else{
//                right = mid-1;
//            }
//        }

        return -1;
    }

    public static int search(int[] array, int x){
        int left = 0;
        int right = array.length-1;

        return search(array,left,right,x);
    }
}
