package com.blog.code.mybatisdomain.memberDomain.application.domain

import java.time.LocalDateTime

class Member(
    val id: Long?,
    val username: String,
    val email: String,
    val lastModifyDate: LocalDateTime?,
)