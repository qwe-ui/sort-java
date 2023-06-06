package com.yxx.tensort;

import java.util.Arrays;

public class Sort {

    //直接插入排序
    public static int[] insertSort(int[] arr) {
        //第一张牌有序，所以从第二张牌开始往前比较
        for (int i = 1; i < arr.length; i++) {
            //把这张牌拿在手里
            int temp = arr[i];
            int j = i;
            //从该牌的左起第一张开始比较，手牌小于左边的牌，则将左边的牌后移
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //折半插入排序
    public static int[] binInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0;
            int high = i - 1;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] <= temp)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            high++;
            for (int j = i; j >= high + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[high] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            /*
                设定一个标记，若为true，则表示此次循环没有进行交换，
                也就是待排序列已经有序，排序已经完成。
                例如已经顺序排好的数列。
            */
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //选择排序

    public static int[] selectSort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    // 记录目前能找到的最小值元素的下标
                    minPos = j;
                }
            }
            if (i != minPos) {
                int temp = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }


    //快速排序
    public static int[] quickSort(int[] arr, int L, int R) {
        if (L >= R)
            return arr;
        int left = L, right = R;
        /*
            基本思想
            1.选定Pivot中心轴
            2.将大于Pivot的数字放在Pivot的右边
            3.将小于Pivot的数字放在Pivot的左边
            4.分别对左右子序列重复前三部操作。
         */
        int pivot = arr[left];
        while (left < right) {
            //右下标对应的元素若大于pivot，则不进行操作，右下标自减
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            //退出上面的while循环，代表右下标遇到了比pivot小的元素，将该元素放到左边
            if (left < right) {
                arr[left] = arr[right];
            }
            //左右下标 双向奔赴
            //左下标对应的元素若小于pivot，则不进行操作，左下标自增
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //退出上面的while循环，代表左下标遇到了比pivot大的元素，将该元素放到右边
            if (left < right) {
                arr[right] = arr[left];
            }
            //左右下标 双向奔赴 将pivot放在左右下标交汇点
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        System.out.println(Arrays.toString(arr));
        //递归调用，分别对左右子序列重复进行上述操作
        quickSort(arr, L, right - 1);
        quickSort(arr, right + 1, R);
        return arr;
    }


    //归并排序
    public static int[] mergeSort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = Arrays.copyOf(arr, arr.length);
        if (temp.length < 2) {
            return temp;
        }
        int mid = (int) Math.floor(temp.length / 2);
        //分而治之的分
        int[] left = Arrays.copyOfRange(temp, 0, mid);
        int[] right = Arrays.copyOfRange(temp, mid, temp.length);
        //递归调用，将左右子序列继续分为两组，直至每组只有一个元素
//        System.out.println(Arrays.toString(temp));
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0;

        while (left.length > 0 && right.length > 0) {
            //比较两个子序列中的第一个元素，将较小元素加入到结果序列中
            if (left[0] < right[0]) {
                result[i++] = left[0];
                //此步操作相当于剔除left序列中的第一个元素，从而诞生新的第一个元素
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        //当一方序列的元素全部加入到结果序列中后，将剩余子序列的元素全部加入到结果序列中
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }


    // 堆排序
    public static int[] heapSort(int[] sourceArray) {

        //对传进来的数组拷贝
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //获取传进来的数组的长度
        int len = arr.length;
        //以该数组来建一个堆
        buildMaxHeap(arr, len);
        //将堆尾元素和堆首元素交换，交换到堆尾的元素已经排好序了，所以数组长度/堆长度减一
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    //建立大顶堆  因为下标是从0开始 所以其实这里的len/2是最后一个非叶节点或非叶节点的下一个 但是不影响结果
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 功能： 完成将以i对应的非叶节点的数，调整成大顶堆
     *
     * @param arr 待调整数组
     * @param i   第一个非叶节点
     * @param len 调整长度
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;    //根节点下标从0开始 双亲节点下标是i 子节点下标是2i+1和2i+2
        int right = 2 * i + 2;
        int largest = i;

        //左孩子的值比爹大  那就左孩子当爹
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        //有孩子的值比爹大  那就有孩子当爹
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        //如果最大值发生了变化，则可能会产生新的最大值，进行递归调用
        if (largest != i) {
            //将最大值对应的下标作为双亲结点
            swap(arr, i, largest);
            //递归调用
            heapify(arr, largest, len);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //******************************************************************************

    //直接插入排序
    public static int[] insertSortZ(int[] arr) {
        //第一张牌有序，所以从第二张牌开始往前比较
        for (int i = 1; i < arr.length; i++) {
            //把这张牌拿在手里
            int temp = arr[i];
        /*
            j=i-1就是从这张牌的前一张开始比较，
            只要还没到最左边的牌，就一直比较下去
         */
            int j;
            for (j = i - 1; j >= 0; j--) {
                //前面的牌比手牌大，那就把前面的牌往后移
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else
                    break;
            }
            arr[++j] = temp;
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //折半插入排序
    public static int[] binInsertSortZ(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0;
            int high = i - 1;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] <= temp)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            high++;
            for (int j = i; j >= high + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[high] = temp;
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //希尔排序
    public static int[] shellSortZ(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //冒泡排序
    public static int[] bubbleSortZ(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            /*
                设定一个标记，若为true，则表示此次循环没有进行交换，
                也就是待排序列已经有序，排序已经完成。
                例如已经顺序排好的数列。
            */
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //选择排序

    public static int[] selectSortZ(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //快速排序
    public static int[] quickSortZ(int[] arr, int L, int R) {
        if (L >= R)
            return arr;
        int left = L, right = R;
        /*
            基本思想
            1.选定Pivot中心轴
            2.将大于Pivot的数字放在Pivot的右边
            3.将小于Pivot的数字放在Pivot的左边
            4.分别对左右子序列重复前三部操作。
         */
        int pivot = arr[left];
        while (left < right) {
            //右下标对应的元素若大于pivot，则不进行操作，右下标自减
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            //退出上面的while循环，代表右下标遇到了比pivot小的元素，将该元素放到左边
            if (left < right) {
                arr[left] = arr[right];
            }
            //左右下标 双向奔赴
            //左下标对应的元素若小于pivot，则不进行操作，左下标自增
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //退出上面的while循环，代表左下标遇到了比pivot大的元素，将该元素放到右边
            if (left < right) {
                arr[right] = arr[left];
            }
            //左右下标 双向奔赴 将pivot放在左右下标交汇点
            if (left >= right) {
                arr[left] = pivot;
            }
        }
//        System.out.println(Arrays.toString(arr));
        //递归调用，分别对左右子序列重复进行上述操作
        quickSortZ(arr, L, right - 1);
        quickSortZ(arr, right + 1, R);
        return arr;
    }


    //归并排序
    public static int[] mergeSortZ(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = Arrays.copyOf(arr, arr.length);
        if (temp.length < 2) {
            return temp;
        }
        int mid = (int) Math.floor(temp.length / 2);
        //分而治之的分
        int[] left = Arrays.copyOfRange(temp, 0, mid);
        int[] right = Arrays.copyOfRange(temp, mid, temp.length);
        //递归调用，将左右子序列继续分为两组，直至每组只有一个元素
//        System.out.println(Arrays.toString(arr));
        return mergeZ(mergeSortZ(left), mergeSortZ(right));
    }

    private static int[] mergeZ(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0;

        while (left.length > 0 && right.length > 0) {
            //比较两个子序列中的第一个元素，将较小元素加入到结果序列中
            if (left[0] < right[0]) {
                result[i++] = left[0];
                //此步操作相当于剔除left序列中的第一个元素，从而诞生新的第一个元素
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        //当一方序列的元素全部加入到结果序列中后，将剩余子序列的元素全部加入到结果序列中
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }


    // 堆排序
    public static int[] heapSortZ(int[] sourceArray) {

        //对传进来的数组拷贝
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //获取传进来的数组的长度
        int len = arr.length;
        //以该数组来建一个堆
        buildMaxHeapZ(arr, len);
        //将堆尾元素和堆首元素交换，交换到堆尾的元素已经排好序了，所以数组长度/堆长度减一
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapifyZ(arr, 0, len);
        }
        return arr;
    }

    //建立大顶堆  因为下标是从0开始 所以其实这里的len/2是最后一个非叶节点或非叶节点的下一个 但是不影响结果
    private static void buildMaxHeapZ(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapifyZ(arr, i, len);
        }
    }

    /**
     * 功能： 完成将以i对应的非叶节点的数，调整成大顶堆
     *
     * @param arr 待调整数组
     * @param i   第一个非叶节点
     * @param len 调整长度
     */
    private static void heapifyZ(int[] arr, int i, int len) {
        int left = 2 * i + 1;    //根节点下标从0开始 双亲节点下标是i 子节点下标是2i+1和2i+2
        int right = 2 * i + 2;
        int largest = i;

        //左孩子的值比爹大  那就左孩子当爹
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        //有孩子的值比爹大  那就有孩子当爹
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        //如果最大值发生了变化，则可能会产生新的最大值，进行递归调用
        if (largest != i) {
            //将最大值对应的下标作为双亲结点
            swap(arr, i, largest);
            //递归调用
            heapifyZ(arr, largest, len);
        }
    }
}

