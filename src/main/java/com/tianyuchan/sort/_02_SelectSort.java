package com.tianyuchan.sort;

/**
 * _02_SelectSort 选择排序
 * 思路：遍历N-1次，每次遍历从未排序范围内“选择”（比较并记录）最大值放到最右边。
 * 相对冒泡排序优化：比较后出现乱序不用立刻交换位置，从而减少交换次数
 * 平均时间复杂度：   O(N^2)     受数据分布影响不大      s = 比较次数 + 交换次数 = N*(N-1)/2 + N-1
 * 最好情况：        O(N^2)
 * 最坏情况：        O(N^2)
 * 空间复杂度：      O(1)       不需要额外空间辅助
 * 排序方式：                   内部排序
 * 稳定性：                    不稳定（存在跳跃性交换，如 8 3 8 1，第一次交换的数据是1和头部的8，两个8原来的顺序被打乱）
 * @author tianyuchan
 * @since 2024/6/20
 */

public class _02_SelectSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int l, r, max;
        for (r = nums.length - 1; r > 0; r--) {
            max = 0;
            for (l = 0; l <= r; l++) {
                // 若 nums[l] >= nums[max]，则可保证稳定性
                if (nums[l] > nums[max]) {
                    max = l;
                }
            }
            // 找出未排序范围内的最大值后再进行交换
            swap(nums, max, r);
        }
    }
}
