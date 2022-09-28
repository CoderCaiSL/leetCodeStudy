package com.example.leetcodestudy.algorithm.simple

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author: CaiSongL
 * @date: 2022/1/17 21:34
 */
class LongestCommonPrefix {

    /**
     * 执行用时：
    168 ms
    , 在所有 Kotlin 提交中击败了
    86.32%
    的用户
    内存消耗：
    35.4 MB
    , 在所有 Kotlin 提交中击败了
    37.61%
    的用户
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        for (i in strs[0].indices){
            for (s in strs){
                if (!s.startsWith(strs[0][i],false)){
                    return result
                }
            }
            result = strs[0][i].toString()
            var tmpJ = result
            if (i != strs[0].length){
                for (j in i+1 until strs[0].length){
                    tmpJ += strs[0][j].toString()
                    for (s in strs){
                        if (!s.startsWith(tmpJ)){
                            return result
                        }
                    }
                    result = tmpJ
                }
            }
            break
        }
        return result
    }
    /**
     * 查找出最长公共（注意，不限制于是否是前缀）
     */
    fun longestCommonPrefixAll(strs: Array<String>): String {
        var result = ""
        var minStr = strs[0]
        for (s in strs){
            if (minStr.length < s.length){
                minStr = s
            }
        }
        for (i in minStr.indices){
            var isContainsI = true
            var tmpI = ""
            for (s in strs){
                if (!s.contains(minStr[i],false)){
                    isContainsI = false
                    break
                }
            }
            if (!isContainsI){
                continue
            }
            tmpI = minStr[i].toString()
            var tmpJ = tmpI
            if (i != minStr.length){
                for (j in i+1 until minStr.length){
                    tmpJ += minStr[j].toString()
                    var isContainsJ = true
                    for (s in strs){
                        if (!s.contains(tmpJ,false)){
                            isContainsJ = false
                            break
                        }
                    }
                    if (isContainsJ){
                        tmpI = tmpJ
                    }else{
                        break
                    }
                }
            }
            if (tmpI.length > result.length){
                result = tmpI
            }
        }
        return result

    }

}

fun main() {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("reflower","flow","flight")))
}