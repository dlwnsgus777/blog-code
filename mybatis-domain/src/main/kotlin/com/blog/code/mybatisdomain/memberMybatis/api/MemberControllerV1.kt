package com.blog.code.mybatisdomain.memberMybatis.api

import com.blog.code.mybatisdomain.memberMybatis.application.MemberServiceV1
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/members")
class MemberControllerV1(
    private val memberServiceV1: MemberServiceV1
) {

    @GetMapping("/{memberId}")
    fun getMember(@PathVariable("memberId") memberId: Long) {
       val memberDto: MemberDto = memberServiceV1.getMember(memberId)
        println(memberDto)
    }
}