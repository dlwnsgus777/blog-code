package com.blog.code.mybatisdomain.memberMybatis.application.dto

import java.time.LocalDateTime

data class MemberDto(
    val id: Long?,
    val username: String,
    val email: String,
    val lastModifyDate: LocalDateTime?,
) {

}
