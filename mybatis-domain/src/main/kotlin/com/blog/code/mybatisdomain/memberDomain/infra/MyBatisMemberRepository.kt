package com.blog.code.mybatisdomain.memberDomain.infra

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member
import com.blog.code.mybatisdomain.memberDomain.repository.MemberRepository
import org.springframework.stereotype.Repository

@Repository
class MyBatisMemberRepository(
    val memberMapper: MemberMapperV2
): MemberRepository {

    override fun findById(id: Long): Member {
        val memberVO = memberMapper.findById(id)
        return memberVO.toDomain()
    }
}