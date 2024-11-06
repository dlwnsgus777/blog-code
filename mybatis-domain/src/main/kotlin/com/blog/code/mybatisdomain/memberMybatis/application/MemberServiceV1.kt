package com.blog.code.mybatisdomain.memberMybatis.application

import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceV1(
    private val memberMapperV1: MemberMapperV1
) {
    fun getMember(memberId: Long): MemberDto {
        val memberDto = memberMapperV1.getMember(memberId)
        return memberDto
    }

    fun changeEmail(memberId: Long, email: String) {
        memberMapperV1.findCanModifyMember(memberId)?.let {
            memberMapperV1.changeEmail(memberId, email)
        }
    }
}