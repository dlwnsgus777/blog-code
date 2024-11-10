package com.blog.code.mybatisdomain.memberDomain.application

import com.blog.code.mybatisdomain.memberDomain.application.domain.Member
import com.blog.code.mybatisdomain.memberDomain.repository.MemberRepository
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceV2(
    private val memberRepository: MemberRepository
) {
    fun getMember(memberId: Long): Member {
        return memberRepository.findById(memberId) ?:throw BadRequestException("Member Not Found")
    }

    fun changeEmail(memberId: Long, email: String) {
        memberRepository.findById(memberId)?.let {member: Member ->
            if (member.canChangeEmail()) {
                member.changeEmail(email)
                memberRepository.save(member)
            }
        }
    }
}