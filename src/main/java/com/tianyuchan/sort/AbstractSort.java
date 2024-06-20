package com.tianyuchan.sort;

/**
 * AbstractSort
 *
 * @author tianyuchan
 * @since 2024/6/20
 */

public abstract class AbstractSort implements Sort {

    protected void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
