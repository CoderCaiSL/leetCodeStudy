package com.example.leetcodestudy.algorithm.simple

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author: CaiSongL
 * @date: 2022/1/21 15:56
 */
class MergeTwoLists {

    /**
     *
     * 执行用时：
    160 ms
    , 在所有 Kotlin 提交中击败了
    91.41%
    的用户
    内存消耗：
    34.3 MB
    , 在所有 Kotlin 提交中击败了
    40.49%
    的用户
     *
     * @author: CaiSongL
     * @date: 2022/1/21 17:22
     */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var root = ListNode();
        var listResult = root

        var tmp1 = list1
        var tmp2 = list2
        while (tmp1 != null){
            var value1 = tmp1.`val`
            while (tmp2 != null){
                var value2 = tmp2.`val`
                if (value1 > value2){
                    val tmp = ListNode(value2)
                    listResult.next = tmp
                    listResult = tmp
                    tmp2 = tmp2.next
                }else{
                    break
                }
            }
            val tmp = ListNode(value1)
            listResult.next = tmp
            listResult = tmp
            tmp1 = tmp1.next
        }
        while (tmp2 != null){
            var value2 = tmp2.`val`
            val tmp = ListNode(value2)
            listResult.next = tmp
            listResult = tmp
            tmp2 = tmp2.next
        }
        return root.next
    }

}

fun main() {

    var list1 = arrayListOf(1,2,4)
    var list2 = arrayListOf(1,3,4)
    var listNode1 = ListNode()

    for (i in list1){

    }





}