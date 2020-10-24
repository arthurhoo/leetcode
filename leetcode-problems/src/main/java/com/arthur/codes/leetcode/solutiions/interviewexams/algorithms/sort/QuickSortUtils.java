package com.arthur.codes.leetcode.solutiions.interviewexams.algorithms.sort;

/**
 * @author: Arthur Hu
 * @date: 2019/4/2 下午7:23
 * Description:
 */
public class QuickSortUtils {

    public static void quickSort(final int[] items){

        if(null==items){
            return;
        }

        if(items.length == 0){
            return;
        }


        sortItem(items,0,items.length-1);

    }


    private static void sortItem(final int[] items, final int start, final int end){


        if(null == items || start>end || start < 0 || end < 0 || start>=items.length ||end >= items.length){
            return;
        }

        if(start == end ){
            return;
        }



        int i = start,j=end;

        int item=items[start];

       while(i<j){
           if(items[j] < item){
               if(items[i] > item){
                   exchange(items,i,j);
               }
               i++;
               continue;
           }
           j--;
       }

       if(i == j){
           exchange(items,start,j);
       }

       sortItem(items,start,j-1);
       sortItem(items,j+1,end);


    }


    private static void exchange(final int[] items, final int leftIndex, final int rightIndex){
        if(null == items || leftIndex>rightIndex || leftIndex < 0 || rightIndex >= items.length){
            throw new IllegalArgumentException("the argument is illegal.");
        }

        int exchange = items[leftIndex];

        items[leftIndex] = items[rightIndex];

        items[rightIndex] = exchange;

        return;

    }



    public static void main(String[] args){
        int[] items = new int[]{4,6,1,-1,100,2,10,6,4,6};

        QuickSortUtils.quickSort(items);

        for(int a:items){
            System.out.println(a);
        }
    }

}
