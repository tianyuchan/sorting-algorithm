package com.tianyuchan.sort;

/**
 * _06_MergeSort 归并排序
 * 思路：以中间位置划分为左右两个区间递归处理，直至递归到底层（区间只有一个值），
 *      之后先将两个有序数列合并到临时数组，再将临时数组已排序区间腾到原数组
 * 时间复杂度：平均、最好、最坏  O(N*logN)
 * 空间复杂度：O(N) 【使用辅助空间】
 * 排序方式：外部排序
 * 稳定性：稳定
 * @author tianyuchan
 * @since 2024/6/23
 */

public class _06_MergeSort extends AbstractSort {


    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        this.sort(nums, 0, nums.length, new int[nums.length]);
    }

    private void sort(int[] nums, int l, int r, int[] temp) {
        if (r - 1 <= l) {
            return;
        }
        // 以中间位置划分为左右两个区间
        int m = l + ((r - l) >> 1);
        sort(nums, l, m, temp);
        sort(nums, m, r, temp);
        // 先将两个有序数列合并到临时数组
        int p = l, q = m, i = l;
        while (p < m || q < r) {
            if (q >= r || (p < m && nums[p] <= nums[q])) {
                temp[i++] = nums[p++];
            } else {
                temp[i++] = nums[q++];
            }
        }
        // 再将临时数组腾到原数组
        for (i = l; i < r; i++) {
            nums[i] = temp[i];
        }
    }  // end sort
}
