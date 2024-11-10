package com.blog.code.mybatisdomain.memberDomain.application

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member
import com.blog.code.mybatisdomain.memberDomain.infra.MemberMapperV2
import com.blog.code.mybatisdomain.memberDomain.infra.vo.MemberVO
import com.blog.code.mybatisdomain.memberDomain.repository.MemberRepository
import com.blog.code.mybatisdomain.memberMybatis.application.dto.MemberDto
import com.blog.code.mybatisdomain.memberMybatis.infra.MemberMapperV1
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional
@SpringBootTest
class MemberServiceV2Test : AnnotationSpec() {

    @Autowired
    private lateinit var memberService: MemberServiceV2

    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Autowired
    private lateinit var memberMapperV2: MemberMapperV2

    @Test
    fun `회원을_조회한다`() {
        val saveMember = MemberVO(id = null, username = "username123123", email = "email", lastModifyDate = null)
        memberMapperV2.save(saveMember)
        val result: Member = memberService.getMember(saveMember.id!!)
        result.username shouldBe "username123123"
    }

    @Test
    fun `이메일을_변경_이력이_없으면_변경한다`() {
        val saveMember = MemberVO(id = null, username = "username123123", email = "email", lastModifyDate = null)
        memberMapperV2.save(saveMember)
        val findMember: Member = memberService.getMember(saveMember.id!!)

        memberService.changeEmail(findMember.id!!, "testEmail")

        val result: Member = memberService.getMember(saveMember.id!!)
        result.email shouldBe "testEmail"
    }

    @Test
    fun `이메일을_최근_변경_이력이_있으면_변경되지않는다`() {
        val saveMember = MemberVO(id = null, username = "username123123", email = "email", lastModifyDate = LocalDateTime.now())
        memberMapperV2.save(saveMember)
        val findMember: Member = memberService.getMember(saveMember.id!!)

        memberService.changeEmail(findMember.id!!, "testEmail")

        val result: Member = memberService.getMember(saveMember.id!!)
        result.email shouldBe "email"
    }
}
