package com.blog.code.mybatisdomain.member.application

import com.blog.code.mybatisdomain.member.application.dto.MemberDto
import com.blog.code.mybatisdomain.member.infra.MemberMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberMapper: MemberMapper
) {
    fun getMember(memberId: Long): MemberDto {
        TODO("Not yet implemented")
    }
}