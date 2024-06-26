package com.tianyuchan.sort;

import org.junit.jupiter.api.Test;

class SortTest {

    @Test
    void sort() {
        System.out.println("==>1 冒泡排序");
        testSort(new _01_BubbleSort());
        System.out.println("\n==>2 选择排序");
        testSort(new _02_SelectSort());
        System.out.println("\n==>3 插入排序");
        testSort(new _03_InsertSort());
        System.out.println("\n==>4 希尔排序");
        testSort(new _04_ShellSort());
        System.out.println("\n==>5 快速排序");
        testSort(new _05_QuickSort());
        System.out.println("\n==>6 归并排序");
        testSort(new _06_MergeSort());
        System.out.println("\n==>7 堆排序");
        testSort(new _07_HeapSort());
        System.out.println("\n==>8 基数排序");
        testSort(new _08_RadixSort());
    }

    public static void testSort(Sort sort){
        long start = System.currentTimeMillis();

        // 特殊值测试
        int[] nums1 = null;
        int[] expect1 = null;
        test("test1", sort, nums1, expect1);

        int[] nums2 = {};
        int[] expect2 = {};
        test("test2", sort, nums2, expect2);

        // 边界值测试
        int[] nums3 = {1};
        int[] expect3 = {1};
        test("test3",sort,nums3,expect3);

        // 功能测试
        int[] nums4 = {1,1,1,1,1,1,1,1,1,1};
        int[] expect4 = {1,1,1,1,1,1,1,1,1,1};
        test("test4",sort,nums4,expect4);

        int[] nums5 = {1,2,1,2,1,2,2,1,2,1};
        int[] expect5 = {1,1,1,1,1,2,2,2,2,2};
        test("test5",sort,nums5,expect5);

        int[] nums6 = {0,1,2,3,4,5,6,7,8,9};
        int[] expect6 = {0,1,2,3,4,5,6,7,8,9};
        test("test6",sort,nums6,expect6);

        int[] nums7 = {9,8,7,6,5,4,3,2,1,0};
        int[] expect7 = {0,1,2,3,4,5,6,7,8,9};
        test("test7",sort,nums7,expect7);

        int[] nums8 = {1,9,5,7,3,8,4,6,5,2};
        int[] expect8 = {1,2,3,4,5,5,6,7,8,9};
        test("test8",sort,nums8,expect8);

        int[] nums9 = {11,123,5,56,3,980,4,6,26,2};
        int[] expect9 = {2,3,4,5,6,11,26,56,123,980};
        test("test9",sort,nums9,expect9);

        long end = System.currentTimeMillis();
        System.out.println("time: " + (end-start) + "ms");
    }

    private static void test(String testN, Sort sort, int[] nums, int[] expect){
        System.out.println("==>==>" + testN);
        sort.sort(nums);
        if (nums == null || nums.length == 0) {
            return;
        }

        for(int i=0; i< nums.length; i++) {
            assert nums[i] == expect[i];
        }
    }
}