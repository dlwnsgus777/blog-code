package com.blog.code.mybatisdomain.memberDomain.application.domain

import java.time.LocalDateTime

class Member(
    val id: Long?,
    var username: String,
    var email: String,
    var lastModifyDate: LocalDateTime?,
) {
    fun canChangeEmail(): Boolean {
        return lastModifyDate?.isBefore(LocalDateTime.now().minusDays(5)) ?: true
    }

    fun changeEmail(email: String) {
        this.email = email
        this.lastModifyDate = LocalDateTime.now()
    }
}