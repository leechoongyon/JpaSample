package com.example.controller;

import com.example.model.Book;
import com.example.model.GroupTable;
import com.example.model.Member;
import com.example.repository.GroupTableRepository;
import com.example.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Group;
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
    public Member insertMember(@RequestBody Member member) {
        log.info("member : {}", member);
        GroupTable groupTable = new GroupTable();
        groupTable.setGroupName(member.getGroupTable().getGroupName());
        groupTableRepository.save(groupTable);
        member.setGroupTable(groupTable);
        Member out = memberRepository.save(member);
        log.info("list : {}", out.getGroupTable().getList());
        return out;
    }
}
