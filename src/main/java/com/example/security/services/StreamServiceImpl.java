package com.example.security.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreamServiceImpl implements StreamService {


    @Override
    public List<Integer> sortByNameLength(List<String> names){
        return names.stream().sorted(Comparator.comparing(String::length)).mapToInt(l->l.length()).mapToObj(i->i).collect(Collectors.toList());
    }
    @Override
    public List<String> sortByLongerName(List<String> names){
        return names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }
    @Override
    public List<String> sortByShorterName(List<String> names){
        return names.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }
}
