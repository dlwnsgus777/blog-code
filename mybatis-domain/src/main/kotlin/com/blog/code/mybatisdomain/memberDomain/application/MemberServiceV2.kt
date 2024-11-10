package com.blog.code.mybatisdomain.memberDomain.application

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member
import com.blog.code.mybatisdomain.memberDomain.repository.MemberRepository
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceV2(
    private val memberRepository: MemberRepository
) {
    fun getMember(memberId: Long): Member {
        val member = memberRepository.findById(memberId)
        return member
    }
}