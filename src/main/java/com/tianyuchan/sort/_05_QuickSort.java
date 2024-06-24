package com.tianyuchan.sort;

/**
 * _05_QuickSort 快速排序
 * 思路：找一个值作为基准，双指针由外向内遍历并交换使得左边的值都小于等于基准值，右边的值都大于等于基准值
 *      再递归处理左区间和右区间。
 * 时间复杂度：平均 O(N*logN)  最好 O(N*logN)  最坏 O(N^2)【每次都选择最小值或最大值】
 * 空间复杂度：O(logN) 【递归导致的】
 * 排序方式：内部排序
 * 稳定性：不稳定
 * 优化点：
 * ① 每次不都是以最左边值为基准，而是随机选择一个值
 * ② 当区间变小后，换用简单排序算法
 * @author tianyuchan
 * @since 2024/6/23
 */

public class _05_QuickSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        this.quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        // 以左边界值为基准值，双指针从两边向内遍历并交换
        // 把基准值放到排序合适位置，并实现左边都小于等于基准值，右边都大于等于基准值
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        // 为nums[l]找到合适的位置p(或q)后交换
        swap(nums, j, l);

        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }  // end quickSort
}
