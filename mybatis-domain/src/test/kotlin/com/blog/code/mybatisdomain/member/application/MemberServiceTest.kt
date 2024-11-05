package com.blog.code.mybatisdomain.member.application

import com.blog.code.mybatisdomain.memberMybatis.application.MemberServiceV1
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class MemberServiceTest : AnnotationSpec() {
    @Autowired
    private lateinit var memberServiceV1: MemberServiceV1

    @Autowired
    private lateinit var memberMapperV1: MemberMapperV1

    @Test
    fun `회원을_저장한다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email")
        memberMapperV1.createMember(saveMember)
        val result: MemberDto = memberServiceV1.getMember(saveMember.id!!)
        result.username shouldBe "username123123"
    }

    @Test
    fun `이메일을_변경한다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email")
        memberMapperV1.createMember(saveMember)
        val findMember: MemberDto = memberServiceV1.getMember(1)

        memberServiceV1.changeEmail(findMember.id!!, "testEmail")

        val result: MemberDto = memberServiceV1.getMember(1)
        result.email shouldBe "testEmail"
    }
}

