package com.blog.code.mybatisdomain.memberDomain.application

import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberMapper: MemberMapper
) {
    fun getMember(memberId: Long): MemberDto {
        val memberDto = memberMapper.getMember(memberId)
        return memberDto
    }
}