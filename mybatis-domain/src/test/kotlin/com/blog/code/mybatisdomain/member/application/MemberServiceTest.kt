package com.blog.code.mybatisdomain.member.application

import com.blog.code.mybatisdomain.member.application.dto.MemberDto
import com.blog.code.mybatisdomain.member.infra.MemberMapper
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@Transactional
class MemberServiceTest : AnnotationSpec() {
    @Autowired
    private lateinit var memberService: MemberService

    @Autowired
    private lateinit var memberMapper: MemberMapper

    @Test
    fun `회원을_저장한다`() {
        memberMapper.createMember(MemberDto(id = null, username = "username123123", email = "email"))
        val result:MemberDto = memberService.getMember(1)
        result.username shouldBe "username123123"
    }
}
