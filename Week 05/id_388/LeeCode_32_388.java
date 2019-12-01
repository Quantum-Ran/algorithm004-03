package com.company.leetcode.editor.cn;//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len ; i++) {
            if (s.charAt(i) != ')') {
                continue;
            }
            // == '()'
            if (s.charAt(i - 1) == '(') {
                dp[i] =  (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(dp[i - dp[i - 1] - 1]) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            res = Math.max(dp[i],res);
        }

        return res;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.longestValidParentheses(")(((((()())()()))()(()))("));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
