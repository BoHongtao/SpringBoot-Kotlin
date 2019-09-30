package com.choc.blog.controller.user

import com.choc.blog.model.UserModel
import com.choc.blog.service.UserService
import com.choc.blog.util.ResponseObject
import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import org.apache.catalina.manager.StatusTransformer.setContentType
import org.apache.http.entity.StringEntity

@RestController
@RequestMapping("/user/")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @RequestMapping("add")
    @ResponseBody
    open fun add(@Valid params: RequestParams, errors: BindingResult):ResponseObject {
        if (errors.hasErrors()) {
            return ResponseObject.error(errors)
        }
        val res = userService.addUser(params.name,params.sex,params.phone)
//        var tempString:String?=null
//        var client: OkHttpClient = OkHttpClient()
        return ResponseObject(0, res)
    }
//    @RequestMapping("list")
//    @ResponseBody
//     open fun list():String {
//        val name = "john"
//        val res = userService.listUser(name)
//        return res.toString()
////        return ResponseObject(0, res)
//    }

}