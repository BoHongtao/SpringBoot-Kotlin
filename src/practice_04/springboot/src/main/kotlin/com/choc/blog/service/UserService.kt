package com.choc.blog.service

import com.choc.blog.model.UserModel
import com.choc.blog.util.ResponseCode
import com.choc.blog.util.exception.ServiceException
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Service
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

@Service
open class UserService{
    val logger = LoggerFactory.getLogger(UserService::class.java)
    var name: PString<UserService>? = null
    /*
     * add user
     */
    @Throws(ServiceException::class,Exception::class)
    fun addUser(name:String,sex:String,phone:String):String {
        try{
            val user = UserModel()
            user.name = name
            user.sex = sex
            user.phone = phone
            logger.info("用户名${user.name}")
            logger.info("性别${user.sex}")
            logger.info("手机号${user.phone}")
            user.save()
            logger.info("保存用户成功")
            return "success"
        } catch (e: ServiceException) {
            throw e
        } catch (e: Exception) {
            logger.error("save user failed", e)
            throw ServiceException(ResponseCode.ERROR, "保存用户失败")
        }
    }
//    @Throws(ServiceException::class,Exception::class)
//    fun listUser(name:String){
//        try {
//            val order = UserModel().find.findList()
//            return order.toString()
//        }catch (e:Exception){
//            logger.error("list user failed", e)
//            throw ServiceException(ResponseCode.ERROR, "保存用户失败")
//        }
//    }
}