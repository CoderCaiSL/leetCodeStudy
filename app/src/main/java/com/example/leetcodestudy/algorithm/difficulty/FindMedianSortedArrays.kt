package com.example.leetcodestudy.algorithm.difficulty

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @author: CaiSongL
 * @date: 2022/1/25 11:14
 */
class FindMedianSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var mergeArray = ArrayList<Int>()
        var i = 0
        var j = 0;
        if (nums1.isEmpty()){
            mergeArray.addAll(nums2.toList())
            j = nums2.size
        }
        if (nums2.isEmpty()){
            mergeArray.addAll(nums1.toList())
            i = nums1.size
        }
        while (i < nums1.size && j < nums2.size){
            if(nums1[i] < nums2[j]){
                mergeArray.add(nums1[i])
                i++
            }else{
                mergeArray.add(nums2[j])
                j++
            }
        }
        if (nums1.isNotEmpty() && i < nums1.size){
            mergeArray.addAll(nums1.asList().subList(i,nums1.size))
        }
        if (nums2.isNotEmpty() && j < nums2.size){
            mergeArray.addAll(nums2.asList().subList(j,nums2.size))
        }
        val avg = mergeArray.size / 2
        return if (mergeArray.size % 2 == 0){
            (mergeArray[avg]+mergeArray[avg-1])/2.0
        }else{
            mergeArray[avg].toDouble()
        }
    }

}

fun main() {
    println(FindMedianSortedArrays().findMedianSortedArrays(intArrayOf(),intArrayOf(1)))
}