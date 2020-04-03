package com.practice.leetcode;

import java.util.*;

/**
 * @author: Matthew
 * @Date: 2019/3/9 16:12
 * @Description: leetCode 简单题 https://leetcode-cn.com/problemset/all/?difficulty=%E7%AE%80%E5%8D%95
 */
public class Easy {

    public static void main(String[] args) throws Exception {
        //1. 两数之和
        //int[] ints = twoSum(new int[]{3, 3}, 6);
        //System.out.println("answer : " + ints.toString());

        //7. 整数反转
        //System.out.println(reverse(1534236469));


        //9. 回文数
        //System.out.println(isPalindrome(-121));

        //13. 罗马数字转整数
//        System.out.println("罗马数字转整数:" + romanToInt("III"));
//        System.out.println("罗马数字转整数:" + romanToInt("IV"));
//        System.out.println("罗马数字转整数:" + romanToInt("IX"));
//        System.out.println("罗马数字转整数:" + romanToInt("LVIII"));
//        System.out.println("罗马数字转整数:" + romanToInt("MCMXCIV"));

        //14. 最长公共前缀
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        //20. 有效的括号
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }

    /**
     * 20. 有效的括号
     * 栈 传统
     */

    public static boolean isValid(String s) throws Exception {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid2(String s) throws Exception {
        char[] chars = s.toCharArray();
        int perNum = intoNum(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int num = intoNum(chars[i]);
            if (perNum == num) {
                return true;
            }
            perNum = num;
        }
        return false;
    }

    private static int intoNum(char c) throws Exception {
        switch (c) {
            case '(':
            case ')':
                return 1;
            case '{':
            case '}':
                return 2;
            case '[':
            case ']':
                return 3;
            default:
                throw new Exception("数字非法");
        }
    }


    /**
     * 14. 最长公共前缀
     * 假设第一个就是 逐个比较
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //取第一个值假设他就是公共的
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            char[] ansArr = ans.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < ansArr.length; k++) {
                    //和第二个比较
                    if (chars[j] != ansArr[j]) {
                        return ans.substring(0, j);
                    }
                }
            }
        }

        return ans;
    }


    /**
     * 13. 罗马数字转整数
     * 数组中间隔比较大小
     * 先取出第一位
     * 然后和第二位比较
     * 比较完毕之后 把第二位的值赋值给先取出第一位的变量
     * 继续比较第三位 .....
     */

    public static int romanToInt(String s) throws Exception {
        char[] chars = s.toCharArray();
        int sum = 0;
        int perNum = turnIntoNumber(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int num = turnIntoNumber(chars[i]);
            if (perNum < num) {
                sum -= perNum;
            } else {
                sum += perNum;
            }
            perNum = num;
        }
        sum += perNum;

        return sum;
    }

    private static int turnIntoNumber(char c) throws Exception {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new Exception("数字非法");
        }
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
