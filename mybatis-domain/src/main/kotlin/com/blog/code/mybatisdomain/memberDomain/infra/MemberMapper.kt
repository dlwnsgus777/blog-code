package com.blog.code.mybatisdomain.memberDomain.infra

import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface MemberMapper {
    fun getMember(@Param("memberId") memberId: Long): MemberDto
    fun createMember(memberDto: MemberDto)
}