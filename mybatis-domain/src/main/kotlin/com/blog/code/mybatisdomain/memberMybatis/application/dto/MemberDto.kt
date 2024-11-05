package com.blog.code.mybatisdomain.memberMybatis.application.dto

import org.apache.ibatis.type.Alias

data class MemberDto(
    val id: Long?,
    val username: String,
    val email: String,
) {

}
