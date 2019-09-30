package com.choc.blog.util

class ResponseError(val code: Int, val msg: String) : Exception() {

}