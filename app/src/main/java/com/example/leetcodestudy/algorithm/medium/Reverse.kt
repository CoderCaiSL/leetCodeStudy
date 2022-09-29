package com.example.leetcodestudy.algorithm.medium

import java.lang.StringBuilder
import kotlin.math.abs

/**
 *
 * https://leetcode.cn/problems/reverse-integer/
 *
 * @author: CaiSongL
 * @date: 2022/9/29 14:21
 */
class Reverse {


    fun reverse(x: Int): Int {
        var str = x.toString();
        if (str.length == 1 || (x < 0 && str.length == 2)){
            return x
        }
        val strB = StringBuilder()
        var startStr = ""
        if (x < 0){
            startStr = "-"
            str = str.substring(1)
        }
        val maxInt = Int.MAX_VALUE
        val maxStr = maxInt.toString()
        var minStr = Int.MIN_VALUE.toString()
        minStr = minStr.substring(1)
        var isNeedCompare = if (x > 0) {
            maxInt.toString().length <= x.toString().length
        }else{
            maxInt.toString().length <= x.toString().length - 1
        }
        strB.append(startStr)
        for (i in str.length - 1 downTo 0){
            if (isNeedCompare){
                if (x > 0){
                    if (str[i] > maxStr[maxStr.length - 1 - i]){
                        return 0
                    }else if (str[i] < maxStr[maxStr.length - 1 - i]){
                        isNeedCompare = false
                    }
                }else{
                    if (str[i] > minStr[minStr.length - 1 - i]){
                        return 0
                    }else if (str[i] < minStr[minStr.length - 1 - i]){
                        isNeedCompare = false
                    }
                }
            }
            strB.append(str[i])
        }
        return strB.toString().toInt()
    }

}

fun main() {
    println(Reverse().reverse(-2147483412).toString())
}