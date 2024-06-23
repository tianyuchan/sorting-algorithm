package com.tianyuchan.sort;

/**
 * _01_BubbleSort 冒泡排序
 * 思路：从大到小排序，右边先排，左边后排
 *      循环遍历，每次遍历把左边未排序范围内的最大值“冒泡”（比较和交换位置）到最右边。
 * 平均时间复杂度：  O(N^2)    数据随机分布    s = 比较次数 + 交换次数 = N*(N-1)/2 + N*(N-1)/4    交换的次数平均来说是比较的一半
 * 最好情况：       O(N)      数据顺序分布    s = 比较次数 + 交换次数 = N + 0 = N
 * 最坏情况：       O(N^2)    数据逆序分布    s = 比较次数 + 交换次数 = N*(N-1)/2 + N*(N-1)/2    每次比较都需要交换
 * 空间复杂度：     O(1)      不需要额外空间辅助
 * 排序方式：                 内部排序（不借助外部数组）
 * 稳定性：                   稳定（不存在跳跃交换）
 * 排序算法稳定性：是指排序之后，两个相同元素之间位置不会发生改变。在二次排序的时候比较重要。
 * @author tianyuchan
 * @since 2024/6/20
 */

public class _01_BubbleSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        boolean swapped;
        int in, out;
        for(out = nums.length - 1; out > 0; out--) {
            swapped = false;
            // r 位置处尚未排序
            for (in = 0; in < out; in++) {
                // 大于才交换位置，相等不交换位置，保证了稳定性
                if (nums[in] > nums[in + 1]) {
                    swap(nums, in, in + 1);
                    swapped = true;
                }
            }
            // 本次遍历不存在乱序，说明已经排好
            if(!swapped) {
                return;
            }
        }
    }  // end sort()

}
