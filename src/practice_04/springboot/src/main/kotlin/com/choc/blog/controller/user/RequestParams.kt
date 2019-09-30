package com.choc.blog.controller.user

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

//user verity
open class RequestParams{
//    @NotNull
//    @Min(1)
//    var id: Int = 0

    @NotNull
    @Size(min = 1)
    var name : String = ""

    var sex : String = ""

    var phone : String = ""

}