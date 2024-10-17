package com.blog.code.mybatisdomain.member.application

import io.kotest.core.spec.style.AnnotationSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@Transactional
class MemberServiceTest : AnnotationSpec() {
    @Test
    fun `테스트해보자`() {
        println("test")
    }

}
