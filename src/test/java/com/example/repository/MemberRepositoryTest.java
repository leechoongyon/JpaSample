package com.example.repository;

import com.example.model.Member;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {

        //given
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        memberRepository.save(member);

        // when
        Member retrivedMember = memberRepository.findById(member.getId()).get();

        // then
        Assert.assertEquals(retrivedMember.getName(), "andrew");
        Assert.assertEquals(retrivedMember.getAge(), Integer.valueOf(32));
    }

//    @Test
//    public void selectMemberTest() {
//
//        //given
//        Member member = new Member();
//        member.setName("andrew");
//        Member tmp = memberRepository.findByfindByName(member.getName());
//        Assert.assertEquals(tmp.getName(), member.getName());
//    }
}