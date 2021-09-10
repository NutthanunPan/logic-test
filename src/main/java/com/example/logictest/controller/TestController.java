package com.example.logictest.controller;

import com.example.logictest.service.FindMaxDistToClosestService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private final FindMaxDistToClosestService findMaxDistToClosestService;

    public TestController(FindMaxDistToClosestService findMaxDistToClosestService) {
        this.findMaxDistToClosestService = findMaxDistToClosestService;
    }

    @GetMapping("/seats")
    public Integer get(@RequestParam @Nullable String params) {
        List<String> lists = Arrays.asList(params.split(",", -1));
        List<Integer> seats = lists.stream().map(Integer::parseInt).collect(Collectors.toList());
        return findMaxDistToClosestService.execute(seats);
    }
}
