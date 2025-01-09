package com.powernode.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicSort {

    private static final int[] arr = {53, 3, 542, 728, 14, 214};

    public static int[] sort(int[] arr) {
//        1.找出最大值
        int max = arr[0];
        for (int temp : arr) {
            if (temp > max) {
                max = temp;
            }
        }
//        2.计算最大值拥有几位数
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
//        3.创建桶0--9
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        int mold = 10;
        int div = 1;
//        4.控制一共取多少次位数
        for (int i = 0; i < maxDigit; i++, mold *= 10, div *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] % mold / div;
                bucket.get(num).add(arr[j]);
            }

            int index = 0;
            for (int k = 0; k < bucket.size(); k++) {
                ArrayList<Integer> list = bucket.get(k);
                for (int m = 0; m < list.size(); m++) {
                    arr[index++] = list.get(m);
                }
                bucket.get(k).clear();
            }

        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] sort = sort(arr);
        int[] sort2=sort2(arr);
        System.out.println(Arrays.toString(sort2));


    }

    public static int[] sort2(int[] arrays) {
        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (max < arrays[i]) {
                max = arrays[i];
            }
        }

        int maxlength = (max + "").length();
        //二维数组，初始化10个桶
        int[][] bucket = new int[10][arrays.length];

        //用来记录每个桶放元素的个数
        int[] bucketElementCount = new int[10];

        //第一次比较     个位数
        for (int j = 0; j < arrays.length; j++) {
            int locationElement = arrays[j] / 1 % 10;
            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        int index = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            for (int l = 0; l < bucketElementCount[k]; l++) {
                arrays[index++] = bucket[k][l];
            }
            bucketElementCount[k] = 0;
        }

//        第二次比较 十位数
        for (int j = 0; j < arrays.length; j++) {
            int locationElement = arrays[j] / 10 % 10;
            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        int index2 = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            for (int l = 0; l < bucketElementCount[k]; l++) {
                arrays[index2++] = bucket[k][l];
            }
            bucketElementCount[k] = 0;
        }

//        第三次比较 十位数
        for (int j = 0; j < arrays.length; j++) {
            int locationElement = arrays[j] / 100 % 10;
            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }
        int index3 = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            for (int l = 0; l < bucketElementCount[k]; l++) {
                arrays[index3++] = bucket[k][l];
            }
            bucketElementCount[k] = 0;
        }

        return arrays;

    }
}
