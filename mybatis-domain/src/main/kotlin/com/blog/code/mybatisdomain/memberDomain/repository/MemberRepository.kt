package com.blog.code.mybatisdomain.memberDomain.repository

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member

interface MemberRepository {
    fun findById(id: Long): Member?
    fun save(member: Member)
}