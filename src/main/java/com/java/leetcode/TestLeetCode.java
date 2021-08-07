package com.java.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/14 8:40
 */
public class TestLeetCode {
    private int[] nums = {-1, 0, 0, 6, 55, 88, 6, 0, 6};

    /**
     * 测试break和continue
     */
    @Test
    public void test1() {
      /*  for (int i = 0; i < 100; i++) {
            if(i/2!=0){
                break;
            }
            System.out.println(i);
        }*/
      int i=0;
      while (i<50){
          i++;
          if(i==20){
              break;
          }
          System.out.println(i);
      }
    }

    @Test
    public void testTwoSum() {
        System.out.println( nFactorial(5));
        int target = 7;
   //     System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    @Test
    public void moveZeroes() {

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void maxAree() {
        ArrayList<Object> objects = new ArrayList<>();

        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));

    }

    @Test
    public void threeSum() {
        int[] arr = {-1, 0, 1, 2, -3, -4};
      //  System.out.println(threeSum(arr));

    }

    @Test
    public void climbStairs() {
        List<Integer> list = Arrays.asList(1, 3, 4, 5);
        System.out.println(climbStairs(999));

    }
    /**
     * 爬楼梯
     * 思路分析：因为只能跨1步或者2步 最后一步可能跨1步或者2步
     * 1阶 1
     * 2阶 f(1)+f(0)
     * 3=最后一步跨1步的次数+最后一步跨2步的次数=f(2)+f(1)
     * ......
     * n=最后一步胯1步+最后一步跨2步=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
    public int nFactorial(int n) {
       if(n<0)return -1;
        if(n==1) return 1;
        else {
            return n* nFactorial(n-1);
        }
    }

    /**
     * 枚举法 left bar x right bar y (x-y)*height_diff
     *
     * @param
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] > height[right] ? height[right--] : height[left++];
            int area = minHeight * (right - left + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    // 将数组中0移动到数组后面位置去
    //1. 定义一个指针 非0元素的个数 j=0 遍历数组 从j位置开始放元素
    // 2.j++
    // 3.从j位置开发填补0
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }

        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    // 方法二:
    public int[] twoSum(int[] nums, int target) {
        //1.放到hashMap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }
        //2 看hash是否包含这个值 包含就返回这个值 所以 key值 value为索引

        for (int i = 0; i < nums.length; i++) {
            int findEle = target - nums[i];
            Integer j = map.get(findEle);
            if (map.containsKey(findEle) && j != i) {
                return new int[]{i, j};
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 双指针法 双指针逼近
    // 暂时还没写呢？
    public int[] twoSum3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {

        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
