package com.example.controller;

import com.example.model.GroupTable;
import com.example.model.Member;
import com.example.repository.GroupTableRepository;
import com.example.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GroupTableRepository groupTableRepository;

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable long id) {
        Optional<Member> member = Optional.of(memberRepository.findById(id).orElse(new Member()));
        return member.get();
    }

    @RequestMapping("/member")
    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        log.info("member : {}", member);
        GroupTable groupTable = new GroupTable();
        groupTable.setGroupName(member.getGroupTable().getGroupName());
        groupTable.setGroupId(member.getGroupTable().getGroupId());
        groupTableRepository.save(groupTable);
        member.setGroupTable(groupTable);
        Member out = memberRepository.save(member);
        log.info("list : {}", out.getGroupTable().getMembers());
        return out;
    }

    /**
     * GroupId 를 통해 속한 Member 를 가져온다.
     * ManyToOne Test
     * 원하는 멤버만 나와야 하는데 무한 루프? 를 돌아서 데이터 엄청 나옴.
     * --> ToString 때문인거 같음. @Data 걸지말고 Getter, Setter 만 걸기. @ToString 걸면 양방향일 경우 에러 발
     */
    @RequestMapping("/group/{id}")
    @GetMapping
    public String findMemberInGroup(@PathVariable long id) {
        log.info("id : {}", id);
        GroupTable groupTable = groupTableRepository.findById(id).get();
        List<Member> members = groupTable.getMembers();
        members.forEach(member -> {
            log.info("member id : {}", member.getId());
        });
        return "SUCCESS";
    }
}
