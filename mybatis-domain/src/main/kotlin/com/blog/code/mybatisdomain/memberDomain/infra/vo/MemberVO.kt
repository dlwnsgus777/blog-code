package com.blog.code.mybatisdomain.memberDomain.infra.vo

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member
import java.time.LocalDateTime

data class MemberVO(
    val id: Long?,
    val username: String,
    val email: String,
    val lastModifyDate: LocalDateTime?,
) {
    fun toDomain(): Member {
        return Member(
            id = this.id,
            username = this.username,
            email = this.email,
            lastModifyDate = lastModifyDate,
        )
    }
}