package com.choc.blog.util.exception


class ServiceException(code: Int, msg: String): Exception() {
    var code: Int = 0
    var msg: String = ""
    var data: Any? = null

    init {
        this.code = code
        this.msg = msg
    }
    constructor(code: Int, msg: String, data: Any) : this(code, msg) {
        this.data = data
    }

}