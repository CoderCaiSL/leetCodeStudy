package com.example.leetcodestudy.algorithm.medium

/**
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/submissions/
 *将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * @author: CaiSongL
 * @date: 2022/1/27 15:05
 */
class ZConvert {


    fun convert(str: String, numRows: Int): String {
        if (numRows == 1){
            return str
        }
        var s = str
        var column = getColumnNumber(s,numRows)
        var strMatrix = Array(numRows) { Array(column) { it -> "" } }
        var endRowIndex = 0
        for (tmpC in 0 until column){
            if (s.isEmpty()){
                break
            }
            if (tmpC % (numRows - 1) == 0){
                for (tmpR in 0 until numRows){
                    if (s.isEmpty()){
                        break
                    }
                    strMatrix[tmpR][tmpC] = s[0].toString()
                    s = s.substring(1)
                    endRowIndex = tmpR
                }
            }else{
                endRowIndex -= 1
                strMatrix[endRowIndex][tmpC] = s[0].toString()
                s = s.substring(1)
            }
        }
        var resultStr = ""
        for (i in 0 until numRows){
            for (j in 0 until column){
                if (strMatrix[i][j].isNotEmpty()){
                    resultStr += strMatrix[i][j]
                }
            }
        }
        return resultStr
    }



    fun getColumnNumber(s: String, numRows: Int) : Int{
        var num = if (numRows > 2)  numRows - 2 else 0
        var row = s.length / (numRows+num) * (numRows-1)
        val yu = s.length % (numRows+num)
        if (yu in 1..numRows){
            row += 1;
        }else if (yu > numRows){
            row += yu;
        }
        return row;
    }


}


fun main() {
    println(ZConvert().convert("PAYPALISHIRING",4))
}