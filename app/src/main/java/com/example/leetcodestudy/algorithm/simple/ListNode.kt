package com.example.leetcodestudy.algorithm.simple

/**
 * @author: CaiSongL
 * @date: 2022/1/21 16:25
 */
public class ListNode {
    var `val` = 0
    var next: ListNode? = null

    constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}