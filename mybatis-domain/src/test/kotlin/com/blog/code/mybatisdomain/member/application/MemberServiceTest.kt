package com.blog.code.mybatisdomain.member.application

import com.blog.code.mybatisdomain.memberMybatis.application.MemberServiceV1
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional
@SpringBootTest
class MemberServiceTest : AnnotationSpec() {
    @Autowired
    private lateinit var memberServiceV1: MemberServiceV1

    @Autowired
    private lateinit var memberMapperV1: MemberMapperV1

    @Test
    fun `회원을_저장한다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email", lastModifyDate = null)
        memberMapperV1.createMember(saveMember)
        val result: MemberDto = memberServiceV1.getMember(saveMember.id!!)
        result.username shouldBe "username123123"
    }

    @Test
    fun `이메일을_변경한다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email", lastModifyDate = null)
        memberMapperV1.createMember(saveMember)
        val findMember: MemberDto = memberServiceV1.getMember(saveMember.id!!)

        memberServiceV1.changeEmail(findMember.id!!, "testEmail")

        val result: MemberDto = memberServiceV1.getMember(saveMember.id!!)
        result.email shouldBe "testEmail"
    }


    @Test
    fun `이메일을_변경_이력이_없으면_변경한다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email", lastModifyDate = null)
        memberMapperV1.createMember(saveMember)
        val findMember: MemberDto = memberServiceV1.getMember(saveMember.id!!)

        memberServiceV1.changeEmail(findMember.id!!, "testEmail")

        val result: MemberDto = memberServiceV1.getMember(saveMember.id!!)
        result.email shouldBe "testEmail"
    }

    @Test
    fun `이메일을_최근_변경_이력이_있으면_변경되지않는다`() {
        val saveMember = MemberDto(id = null, username = "username123123", email = "email", lastModifyDate = LocalDateTime.now())
        memberMapperV1.createMember(saveMember)
        val findMember: MemberDto = memberServiceV1.getMember(saveMember.id!!)

        memberServiceV1.changeEmail(findMember.id!!, "testEmail")

        val result: MemberDto = memberServiceV1.getMember(saveMember.id!!)
        result.email shouldBe "email"
    }

}

