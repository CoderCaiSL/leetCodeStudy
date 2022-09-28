package com.example.leetcodestudy.algorithm.simple

/**
 * @author: CaiSongL
 * @date: 2022/1/19 14:09
 */
class IsValid {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0){
            return false
        }
        if (s.startsWith(")") || s.startsWith("}") || s.startsWith("]")){
            return false
        }
        if (s.endsWith("(") || s.endsWith("{") || s.endsWith("[")){
            return false
        }
        var tmp = replaceStr(s)
        if (tmp == ""){
            return true
        }else{
            val t = tmp.substring(0,tmp.length / 2)
            if (t.contains(")") || t.contains("}") || t.contains("]")){
                return false
            }
            for(i in 0 until tmp.length / 2){
                if (tmp[i] == '(' && tmp[tmp.length-1-i] != ')'){
                    return false
                }
                if (tmp[i] == '{' && tmp[tmp.length-1-i] != '}'){
                    return false
                }
                if (tmp[i] == '[' && tmp[tmp.length-1-i] != ']'){
                    return false
                }
            }
            return true
        }
    }


    private fun replaceStr(s : String):String{
        var tmp = s
        when {
            tmp.contains("()") -> {
                tmp = s.replace("()","")
            }
            tmp.contains("[]") -> {
                tmp = tmp.replace("[]","")
            }
            tmp.contains("{}") -> {
                tmp = tmp.replace("{}","")
            }
        }
        if (tmp == ""){
            return ""
        }
        return if (tmp.contains("()") ||
            tmp.contains("{}") ||
            tmp.contains("[]")){
            replaceStr(tmp)
        }else{
            tmp
        }
    }
}

fun main() {
    println(IsValid().isValid("{}[{}]((){})(){}"))
}