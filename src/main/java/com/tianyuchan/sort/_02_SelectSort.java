package com.tianyuchan.sort;

/**
 * _02_SelectSort 选择排序
 * 思路：从小到大排序，左边先排，右边待排
 *      循环遍历，每次遍历从右边未排序范围内“选择”（比较并记录）最小值与左边界处交换。
 * 相对冒泡排序优化：比较后出现乱序不用立刻交换位置，从而减少交换次数
 * 平均时间复杂度：   O(N^2)     受数据分布影响不大      s = 比较次数 + 交换次数 = N*(N-1)/2 + N-1
 * 最好情况：        O(N^2)
 * 最坏情况：        O(N^2)
 * 空间复杂度：      O(1)       不需要额外空间辅助
 * 排序方式：                   内部排序
 * 稳定性：                     稳定
 * @author tianyuchan
 * @since 2024/6/20
 */

public class _02_SelectSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int in, out, min;
        for (out = 0; out < nums.length; out++) {
            min = out;
            for (in = out + 1; in < nums.length; in++) {
                // 小于保证了稳定性
                if (nums[in] < nums[min]) {
                    min = in;
                }
            }
            // 未排序范围内的左边界与最小值交换位置
            swap(nums, out, min);
        }
    }  // end sort
}
