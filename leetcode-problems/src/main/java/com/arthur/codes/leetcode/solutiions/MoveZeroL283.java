package com.arthur.codes.leetcode.solutiions;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 备注：这道题有个隐藏条件，如果没有0，不需要进行排序
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 * @author: huhao
 * @create: 2023/11/19
 */
public class MoveZeroL283 {


    /**
     * 使用冒泡排序进行联系，并不是最优解
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        if(null == nums || nums.length < 1 || nums.length > 104 ){
            throw new IllegalArgumentException("非法输入");
        }
        int zeroCount = 0;

        // 记录末尾 0 的数量
        int zeroesCount = 0;
        for (int i = 0; i < nums.length - zeroesCount; i++) {
            if (nums[i] == 0) {
                // 利用冒泡排序的思想，不断交换，将 0 移动到数组末尾
                for (int j = i; j < nums.length - zeroesCount - 1; j++) {
                    swap(nums, j, j + 1);
                }
                // 末尾多了一个 0，记录下来，以缩小遍历范围
                zeroesCount++;
                // 下一轮遍历时 i 会增加 1，但此时 nums[i] 已经和 nums[i+1] 交换了，nums[i+1] 还没有判断是否为 0，所以这里先减 1，以使下一轮继续判断 i 位置。
                i--;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void  moveZero(int[] nums){

    }


    public static void main(String[] args) {
        int[] num1 = new int[]{0,1,0,3,12};
        // bubbleSort
        System.out.println("排序前:");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));
        bubbleSort(num1);
        System.out.println("排序后：");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));

        System.out.println("-------------");
        num1 = new int[]{0};
        System.out.println("排序前:");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));
        bubbleSort(num1);
        System.out.println("排序后：");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));

        System.out.println("-------------");
        num1 = new int[]{1,0};
        System.out.println("排序前:");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));
        bubbleSort(num1);
        System.out.println("排序后：");
        IntStream.of(num1).forEach(iterm -> System.out.println(iterm));


    }
}


