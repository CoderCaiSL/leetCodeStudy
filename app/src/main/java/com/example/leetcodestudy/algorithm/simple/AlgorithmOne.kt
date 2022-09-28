package com.example.leetcodestudy.algorithm.simple


/**
 * 题目详情：https://leetcode-cn.com/problems/two-sum/
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案
 *
 *
 * @author: CaiSongL
 * @date: 2022/1/13 11:20
 */
object AlgorithmOne {
    fun test(datas : IntArray,target : Int) : IntArray{
        var startIndex = 0;
        var endIndex = 0;
        datas.forEachIndexed  { index, s ->
            run {
                if (index < datas.size-1) {
                    for (j in (index + 1) until datas.size) {
                        if ((datas[j] + s) == target) {
                            startIndex = index
                            endIndex = j
                            return@forEachIndexed
                        }
                    }
                }
            }
        }
        return intArrayOf(startIndex,endIndex);
    }

}

fun main() {
    var tmp : IntArray = AlgorithmOne.test(intArrayOf(11,15,2,7),9);
    println(tmp)
}