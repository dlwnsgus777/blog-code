package com.blog.code.mybatisdomain.memberDomain.infra

import com.blog.code.mybatisdomain.memberDomain.infra.vo.MemberVO
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface MemberMapperV2 {
    fun findById(@Param("memberId") id: Long): MemberVO
    fun save(memberVO: MemberVO)
}