package com.example.leetcodestudy.algorithm.medium

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author: CaiSongL
 * @date: 2022/1/26 17:30
 */
class LongestPalindrome {

    fun longestPalindrome(s: String): String {
        var result = ""
        for (i in s.indices){
            var tmp = s[0].toString()
            if (i < s.length-1){
                for (j in s.length downTo i){
                    var t = s.substring(i,j)
                    if (isPalindrome(t)){
                        tmp = t;
                        break
                    }
                }
            }
            if (result.length < tmp.length){
                result = tmp
            }
        }
        return result
    }

    fun isPalindrome(s : String):Boolean{
        var palindrome = true
        if (s.length == 1){
            return palindrome
        }
        for (i in 0 until s.length/2){
            if (s[i] != s[s.length-1-i]){
                palindrome = false
                break
            }
        }
        return palindrome
    }

}

fun main() {

}