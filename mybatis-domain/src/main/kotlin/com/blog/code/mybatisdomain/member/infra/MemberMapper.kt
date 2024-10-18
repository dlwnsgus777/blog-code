package com.blog.code.mybatisdomain.member.infra

import com.blog.code.mybatisdomain.member.application.dto.MemberDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface MemberMapper {
    fun getMember(@Param("memberId") memberId: Long): MemberDto
    fun createMember(memberDto: MemberDto)
}