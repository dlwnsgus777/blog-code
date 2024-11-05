package com.blog.code.mybatisdomain.memberDomain.application

import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceV2(
    private val memberMapperV1: MemberMapperV1
) {
    fun getMember(memberId: Long): MemberDto {
        val memberDto = memberMapperV1.getMember(memberId)
        return memberDto
    }
}