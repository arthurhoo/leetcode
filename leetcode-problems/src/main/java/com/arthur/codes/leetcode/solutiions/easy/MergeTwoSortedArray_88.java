package com.arthur.codes.leetcode.solutiions.easy;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * @author: huhao
 * @create: 2024/4/16
 */
public class MergeTwoSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2 || m < 0 || m > 200 || n < 0 || n > 200 || (m + n) < 1 || (m + n) > 200
                || nums1.length != (m + n) || nums2.length != n) {
            return;
        }

        if (n == 0) {
            return;
        }


        int i = m - 1, j = n - 1, k = m + n - 1;
        if (m == 0) {
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
            return;
        }

        while (i >= 0 && j >= 0 && k >= 0) {

            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                nums1[k - 1] = nums1[i];
                i--;
                k = k - 2;
            }
        }

        // 边界问题很关键
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }


    }


    public static void main(String[] args) {
        MergeTwoSortedArray_88 mergeTwoSortedArray88 = new MergeTwoSortedArray_88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        mergeTwoSortedArray88.merge(nums1, m, nums2, n);

        Arrays.stream(nums1).forEach(a -> System.out.printf("%d,", a));
        System.out.println();

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        mergeTwoSortedArray88.merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(a -> System.out.printf("%d,", a));
        System.out.println();


    }
}
