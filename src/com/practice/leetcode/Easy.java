package com.practice.leetcode;

import java.util.ArrayList;

/**
 * @author: Matthew
 * @Date: 2019/3/9 16:12
 * @Description: leetCode 简单题 https://leetcode-cn.com/problemset/all/?difficulty=%E7%AE%80%E5%8D%95
 */
public class Easy {

    public static void main(String[] args) {
        //1. 两数之和
        //int[] ints = twoSum(new int[]{3, 3}, 6);
        //System.out.println("answer : " + ints.toString());

        //7. 整数反转
        //System.out.println(reverse(1534236469));


        //9. 回文数
        //System.out.println(isPalindrome(-121));

        //13. 罗马数字转整数
        System.out.println(romanToInt("III")+"");
    }

    /**
     * 13. 罗马数字转整数
     */

    public static int romanToInt(String s) {

        return 0;
    }


    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static int reverse(int x) {
        String temp = String.valueOf(x);
        boolean isNegative = false;
        if (temp.startsWith("-")) {
            isNegative = true;
            temp = temp.substring(1);
            temp = temp.replaceAll("0+?$", "");
        }
        if (temp.length() > 32) {
            return 0;
        }

        char[] chars = temp.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = chars.length - 1; i > -1; i--) {
            list.add(chars[i]);
        }
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }
        if (isNegative) {
            result = "-" + result;
        }
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int result = nums[i] + nums[j];
                if (result == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
