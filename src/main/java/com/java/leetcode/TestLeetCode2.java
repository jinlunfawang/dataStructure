package com.java.leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 测试macgit提及哦
 * @version 1.0
 * @Author: liangfangwei
 * @Date: 2020/9/19 14:23
 */
public class TestLeetCode2 {


    /**
     * 列表的反转
     * @param head
     * @return


    /**
     * 三数之和
     * <p>
     * //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
     * //的三元组。
     * //
     * // 注意：答案中不可以包含重复的三元组。
     * //
     *
     * @param nums
     * @return 方法:
     * 1.排好顺
     * 2.如果a[K]>0 break直接退出循环break;如果a[k]=a[k--] continue;
     * 3.if sum=0
     * list.add
     * while(i<j&&a[i]==a[i+1]) k++
     * while(i<j&&a[j]==a[j-1]) j++
     * k++
     * j--
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List res = new ArrayList();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) break;
            if (nums[k] == nums[k-1]) continue;
            int i = k + 1, j = nums.length - 1;
            int sum = nums[k] + nums[j] + nums[j];
            while (i < j) {
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 去重
                    while(i<j&&nums[i]==nums[i+1]) i++;
                    while(i<j&&nums[j]==nums[j-1]) j++;
                    i++;
                    j--;
                }else if(sum<0) i++;
                else if(sum>0) j--;
            }
        }

        return res;
    }


}
