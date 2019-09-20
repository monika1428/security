package com.example.security.services;

import java.util.List;

public interface StreamService {
    List<Integer> sortByNameLength(List<String> names);
    List<String> sortByLongerName(List<String> names);
    List<String> sortByShorterName(List<String> names);

}
