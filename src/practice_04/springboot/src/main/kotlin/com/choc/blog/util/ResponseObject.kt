package com.choc.blog.util

import com.fasterxml.jackson.annotation.*
import com.google.gson.*

class ResponseObject constructor (code: Int = 0, msg: String = "") {

    private val SCHEMATYPE_NULL = "null"
    private val SCHEMATYPE_STRING = "string"
    private val SCHEMATYPE_ARRAY = "array"
    private val SCHEMATYPE_MAP = "object"
    private val SCHEMATYPE_OBJECT = "object"
    private val SCHEMATYPE_RECARDS = "records"

    private var code = ResponseCode.OK
    private var msg = ""
    private var schemaType = SCHEMATYPE_NULL
    private val schemaFields = ""
    private val schemaPages = ""
    private var data: JsonElement? = null

    init {
        this.code = code
        this.msg = msg
    }

    private fun genSchema(): JsonArray {
        val schema = JsonArray()
        schema.add(schemaType)
        schema.add(schemaFields)
        schema.add(schemaPages)
        return schema
    }

    fun getCode():Int {
        return this.code
    }

    fun setCode(code: Int):ResponseObject {
        this.code = code
        return this
    }

    fun setMsg(msg: String):ResponseObject {
        this.msg = msg
        return this
    }


    fun getMsg():String {
        return this.msg
    }

    @JsonIgnore
    fun getStringData():String {
        if(this.data==null) {
            return ""
        }
        if(this.data!!.isJsonPrimitive) {
            return this.data!!.asString
        }
        return ""
    }

    fun setStringData(data: String):ResponseObject {
        this.data = JsonPrimitive(data)
        this.schemaType = SCHEMATYPE_STRING
        return this
    }

    @JsonIgnore
    fun getArrayData():JsonArray? {
        if(this.data==null) {
            return null
        }
        if(this.data!!.isJsonArray) {
            return this.data!!.asJsonArray
        }
        return null
    }

    fun setArrayData(data: Any?):ResponseObject {
        val gson = Gson()
        if(data==null) {
            this.data = JsonArray()
        }
        else {
            this.data = gson.toJsonTree(data)
        }
        this.schemaType = SCHEMATYPE_ARRAY
        return this
    }

    fun setMapData(data: Any):ResponseObject {
        val gson = Gson()
        this.data = gson.toJsonTree(data)
        this.schemaType = SCHEMATYPE_MAP
        return this
    }

    @JsonIgnore
    fun getObjectData():JsonObject? {
        if(this.data==null) {
            return null
        }
        if(this.data!!.isJsonObject) {
            return this.data!!.asJsonObject
        }
        return null
    }

    fun setObjectData(data: Any):ResponseObject {
        val gson = Gson()
        this.data = gson.toJsonTree(data)
        this.schemaType = SCHEMATYPE_OBJECT
        return this
    }

    fun getData():JsonElement? {
        return this.data
    }

    fun setData(data: Any):ResponseObject {
        val gson = Gson()
        this.data = gson.toJsonTree(data)
        this.schemaType = SCHEMATYPE_OBJECT
        return this
    }

    fun converterToString(): String {
        val j = JsonObject()
        j.addProperty("code", code)
        j.addProperty("msg", msg)
        j.add("schema", genSchema())

        if (data == null) {
            j.addProperty("data", "")
        } else {
            j.add("data", data)
        }

        return j.toString()

    }

    override fun toString(): String {
        /*
        var ret = jsonObject(
                "code" to code,
                "msg" to msg,
                "schema" to jsonArray(schemaType, schemaFields, schemaPages)
            )

        return ret.toString()*/
        return ""
    }

    companion object Factory {

        fun error(code: Int, msg: String): ResponseObject {
            val r = ResponseObject(code, msg)
            return r
        }

        fun error(errors: org.springframework.validation.Errors): ResponseObject {
            if (!errors.hasErrors()) {
                return ResponseObject(ResponseCode.INTERNAL_ERROR, "服务器内部错误")
            }
            if (errors.hasFieldErrors()) {
                for (error in errors.fieldErrors) {
                    var msg = String.format("%s", error.code)
                    if (error.codes!!.size == 3) {
                        msg = error!!.codes!![1]
                    }
                    for (i in 0..error.codes!!.size - 1) {
                        //System.out.println(":"+i+":"+error.getCodes()[i]);
                    }
                    return ResponseObject(ResponseCode.INVALID_PARAMETER, msg)
                }
            }
            return ResponseObject(ResponseCode.INTERNAL_ERROR, "服务器错误")
        }

        fun error(errors: org.springframework.validation.BindingResult): ResponseObject {
            if (!errors.hasErrors()) {
                return ResponseObject(ResponseCode.INTERNAL_ERROR, "服务器内部错误")
            }

            if (errors.hasFieldErrors()) {
                for (fieldError in errors.fieldErrors) {
                    val msg = String.format("%s:%s", fieldError.field, fieldError.code)
                    return ResponseObject(ResponseCode.INVALID_PARAMETER, msg)
                }
            }
            return ResponseObject(ResponseCode.INTERNAL_ERROR, "服务器错误")
        }

    }



}