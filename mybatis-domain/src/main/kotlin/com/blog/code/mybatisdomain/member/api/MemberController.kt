package com.blog.code.mybatisdomain.member.api

import com.blog.code.mybatisdomain.member.application.MemberService
import com.blog.code.mybatisdomain.member.application.dto.MemberDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/members")
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/{memberId}")
    fun getMember(@PathVariable("memberId") memberId: Long) {
       val memberDto: MemberDto = memberService.getMember(memberId)
        println(memberDto)
    }
}