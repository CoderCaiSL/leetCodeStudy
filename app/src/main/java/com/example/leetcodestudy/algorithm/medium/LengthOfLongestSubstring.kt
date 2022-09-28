package com.example.leetcodestudy.algorithm.medium

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: CaiSongL
 * @date: 2022/1/24 23:39
 */
class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = ""
        var tmp = ""
        for (i in s.indices){
            var tmp = s[i].toString()
            if (i != s.length-1){
                for (j in i+1 until s.length){
                    if (!tmp.contains(s[j])){
                        tmp += s[j]
                    }else{
                        break
                    }
                }
            }
            if (result.length < tmp.length){
                result = tmp
            }
        }
        return result.length
    }
}

fun main() {

}