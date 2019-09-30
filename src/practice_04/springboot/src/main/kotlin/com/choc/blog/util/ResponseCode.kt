package com.choc.blog.util


open class ResponseCode {
    companion object {
        val OK = 0                 //成功
        val INVALID_PARAMETER = 2 //参数错误
        val ERROR = 1000          //调用失败
        val INTERNAL_ERROR = 500  // 内部错误
    }
}