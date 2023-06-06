package com.yxx.tensort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FinalTest {
    @Test
    public void InsertTest() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("直接插入排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.insertSort(arrays);
        System.out.println("\n直接插入排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.insertSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，直接插入排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void BubbleTest() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("冒泡排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.bubbleSort(arrays);
        System.out.println("\n冒泡排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.bubbleSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，冒泡插入排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void BinInsertSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("折半插入排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.binInsertSort(arrays);
        System.out.println("\n折半插入排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.binInsertSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，折半插入排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void ShellSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("希尔排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.shellSort(arrays);
        System.out.println("\n希尔排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.shellSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，希尔排序耗时" + time + "ms");
        System.out.println();

    }

    @Test
    public void SelectSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("选择排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.selectSort(arrays);
        System.out.println("\n选择排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.selectSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，选择排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void QuickSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(10);
        System.out.println("快速排序前:");
        System.out.println(Arrays.toString(arrays));
        Sort.quickSort(arrays, 0, arrays.length - 1);
        System.out.println("\n快速排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.quickSortZ(arrays, 0, arrays.length - 1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，快速排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void MergeSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(16);
        System.out.println("归并排序前:");
        System.out.println(Arrays.toString(arrays));
        arrays = Sort.mergeSort(arrays);
        System.out.println("\n归并排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.mergeSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，归并排序耗时" + time + "ms");
        System.out.println();
    }

    @Test
    public void HeapSort() {
        //排序过程
        int[] arrays = CreatStuScore.scores(5);
        System.out.println("堆排序前:");
        System.out.println(Arrays.toString(arrays));
        arrays = Sort.heapSort(arrays);
        System.out.println("\n堆排序后:");
        System.out.println(Arrays.toString(arrays));
        //性能测试
        arrays = CreatStuScore.scores(100000);
        long start = System.currentTimeMillis();
        Sort.heapSortZ(arrays);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println();
        System.out.println("对" + arrays.length + "个随机数，堆排序耗时" + time + "ms");
        System.out.println();
    }
}




