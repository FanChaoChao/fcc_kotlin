package com.example.app.entity

data class User constructor(var username:String?,var password : String?,var code : String?){
//    //通过@JvmField
//    var username:String? = null
//    var password:String? = null
//    var code:String? = null
    constructor() : this(null,null,null)

}