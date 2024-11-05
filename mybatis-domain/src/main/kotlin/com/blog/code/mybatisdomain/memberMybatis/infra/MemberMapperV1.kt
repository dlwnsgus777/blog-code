package com.blog.code.mybatisdomain.memberMybatis.infra

import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface MemberMapperV1 {
    fun getMember(@Param("memberId") memberId: Long): MemberDto
    fun createMember(memberDto: MemberDto)
    fun changeEmail(memberId: Long, email: String)
}