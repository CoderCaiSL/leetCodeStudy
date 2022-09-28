package com.example.leetcodestudy.algorithm.scondary

import kotlin.math.abs

/**
 * @author: CaiSongL
 * @date: 2022/3/1 16:08
 */
class Solution {

    fun reverse(x: Int): Int {
        var res = 0
        val tmp = abs(x).toString()
        var resStr = ""
        if (x < 0){
            for (index in tmp.length-1 downTo 0){
                resStr += tmp[index]
            }
        }
        return res
    }


}

