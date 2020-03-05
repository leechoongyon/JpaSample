package com.example.controller;

import com.example.dto.JpaSampleDto;
import com.example.model.Member;
import com.example.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JpaSampleController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public JpaSampleDto isRunning() {
        JpaSampleDto jpaSampleDto = new JpaSampleDto();
        jpaSampleDto.setAaa("aaa");
        jpaSampleDto.setBbb("bbb");
        log.info("jpaSample : {}" , jpaSampleDto);
        return jpaSampleDto;
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
