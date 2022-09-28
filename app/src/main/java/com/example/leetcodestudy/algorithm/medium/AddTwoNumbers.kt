package com.example.leetcodestudy.algorithm.medium

import com.example.leetcodestudy.algorithm.simple.ListNode


/**
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author: CaiSongL
 * @date: 2022/1/21 16:00
 */
class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var root = ListNode()
        var children = root;
        var list1 = l1;
        var list2 = l2;
        var nextNumber : Int = 0
        while (list1 != null || list2 != null){
            when{
                (list1 != null && list2 != null) ->{
                    var tmp = (list1.`val` + list2.`val` + nextNumber) % 10
                    nextNumber = (list1.`val` + list2.`val` + nextNumber) / 10
                    var tmpNode = ListNode(tmp);
                    children.next = tmpNode;
                    children = tmpNode;
                    list1 = list1.next
                    list2 = list2.next
                }
                (list1 != null && list2 == null) -> {
                    var tmp = (list1.`val` + nextNumber) % 10
                    nextNumber = (list1.`val` + nextNumber) / 10
                    var tmpNode = ListNode(tmp)
                    children.next = tmpNode
                    children = tmpNode
                    list1 = list1.next
                }
                (list2 != null && list1 == null) ->{
                    var tmp = (list2.`val` + nextNumber) % 10
                    nextNumber = (list2.`val` + nextNumber) / 10
                    var tmpNode = ListNode(tmp)
                    children.next = tmpNode
                    children = tmpNode
                    list2 = list2.next
                }
            }
        }
        if (nextNumber != 0){
            var tmpNode = ListNode(nextNumber);
            children.next = tmpNode;
        }
        return root.next
    }

}