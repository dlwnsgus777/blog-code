package com.blog.code.mybatisdomain.memberDomain.api

import com.blog.code.mybatisdomain.memberMybatis.application.MemberServiceV1
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/members")
class MemberControllerV2(
    private val memberServiceV1: MemberServiceV1
) {

    @GetMapping("/{memberId}")
    fun getMember(@PathVariable("memberId") memberId: Long) {
       val memberDto: MemberDto = memberServiceV1.getMember(memberId)
        println(memberDto)
    }

    @PostMapping("/{memberId}/change-email")
    fun changeEmail(@PathVariable("memberId") memberId: Long, @RequestParam(value = "email") email: String) {
        memberServiceV1.changeEmail(memberId, email);
    }
}