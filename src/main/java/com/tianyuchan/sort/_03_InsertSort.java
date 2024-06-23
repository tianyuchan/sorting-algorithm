package com.tianyuchan.sort;

/**
 * _03_InsertSort 插入排序
 * 思路：从小到大排序，左边先排，右边后排
 *      循环遍历，将当前位置值在已排范围内从右向左比较，大于当前值则右移留出空位，否则将当前值"插入"空位
 * 平均时间复杂度：  O(N^2)    数据随机分布    s = 比较次数 + 移动次数 + 移动到temp = N*(N-1)/4 + N*(N-1)/4 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后每次比较伴随一次移动；平均来说在中途遇到比较中止条件。
 * 最好情况：       O(N)      数据顺序分布    s = 比较次数 + 移动次数 + 移动到temp = N-1 + N-1 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后比较一次和移动一次；也就是第一次比较就遇到中止条件。
 * 最坏情况：       O(N^2)    数据逆序分布    s = 比较次数 + 移动次数 + 移动到temp = N*(N-1)/2 + N*(N-1)/2 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后每次比较伴随一次移动，直到数组头部；也就是比较完所有数据才中止。
 * 空间复杂度：     O(1)      不需要额外空间辅助
 * 排序方式：                 内部排序
 * 稳定性：                   稳定
 * 优化点：
 * ① 寻找合适位置时，由于左边都是排好序的，可以使用二分法查找，减少比较次数
 * ② 减少移位次数——希尔排序
 * @author tianyuchan
 * @since 2024/6/21
 */

public class _03_InsertSort extends AbstractSort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int in, out;
        for (out = 1; out < nums.length; out++) {
            int temp = nums[out];
            in = out;
            // 右边的大于保证了稳定性
            while (in > 0 && nums[in - 1] > temp) {
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = temp;
        }
    }  // end sort
}
