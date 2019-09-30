package com.choc.blog.model

import io.ebean.Model
import io.ebean.annotation.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@DocStore
@Entity
@Table(name = "user")
@MappedSuperclass
class UserModel : Model(){

    @Size(max = 32)
    @NotNull
    @Id
    @Column(name="id",length=32,nullable=false)
    var id: Int? = null

    @Size(max = 255)
    @Column(name="name",length=40)
    var name:String ? = null

    @Size(max = 255)
    @Column(name="sex")
    var sex:String ? = null

    @Size(max = 255)
    @Column(name="phone")
    var phone:String ? = null

    override fun toString(): String {
        return "id:$id";
    }
}