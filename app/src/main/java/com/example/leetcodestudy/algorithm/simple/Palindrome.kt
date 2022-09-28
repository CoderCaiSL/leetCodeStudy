package com.example.leetcodestudy.algorithm.simple

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 回文数字的判断
 * @author: CaiSongL
 * @date: 2022/1/16 22:41
 */
class Palindrome {
    /**
     * 执行用时：300 ms
     * 内存消耗：35.1 MB
     */
    fun isPalindrome(x: Int): Boolean {
        var tmp = x.toString()
        var oddNumber = false
        oddNumber = tmp.length % 2 != 0
        val averageLength = tmp.length / 2
        if (oddNumber){
            val startStr = tmp.substring(0,averageLength)
            val endStr = tmp.substring(averageLength+1,tmp.length)
            return startStr == endStr.reversed()
        }else{
            val startStr = tmp.substring(0,averageLength)
            val endStr = tmp.substring(averageLength,tmp.length)
            return startStr == endStr.reversed()
        }
    }
    /**
     * 执行用时：200 ms
     * 内存消耗：34.7 MB
     */
    fun isPalindromeEx(x: Int): Boolean {
        if(x < 0){
            return false
        }
        if(x != 0 && x % 10 == 0){
            return false
        }
        var tmp = x.toString()
        for (i in 0..tmp.length / 2){
            if (tmp[i] != tmp[tmp.length - 1 - i]){
                return false
            }
        }
        return true
    }
}

fun main() {

    println(Palindrome().isPalindromeEx(1211))
}