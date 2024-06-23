package com.tianyuchan.sort;

import java.util.PriorityQueue;

/**
 * _07_HeapSort 堆排序
 * 平均时间复杂度：  O(N*logN)    受数据分布影响较小
 * 最好情况：       O(N*logN)
 * 最坏情况：       O(N*logN)
 * 空间复杂度：      O(N)         堆空间大小
 * 排序方式：       外部堆排序
 * 稳定性：         不稳定
 * @author tianyuchan
 * @since 2024/6/23
 */

public class _07_HeapSort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // 默认最小堆
        PriorityQueue<Integer> minHead = new PriorityQueue<>();
        for (int num : nums) {
            minHead.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = minHead.remove();
        }
    }
}
