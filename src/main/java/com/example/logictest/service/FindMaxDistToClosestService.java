package com.example.logictest.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMaxDistToClosestService {

    public Integer execute(List<Integer> seats) {
        int result = 0;
        int occupiedPrev = -1;
        for (int index = 0; index < seats.size(); index++) {
            if (seats.get(index).equals(1)) {
                if (occupiedPrev == -1) {
                    result = index;
                }
                else {
                    result = Math.max(result, (index - occupiedPrev) / 2);
                }
                occupiedPrev = index;
            }
        }
        return Math.max(result, seats.size() - 1 - occupiedPrev);
    }
}
