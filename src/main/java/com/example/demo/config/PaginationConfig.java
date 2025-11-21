package com.example.demo.config;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationConfig {
    public static Pageable createPageRequest(int page, int size) {
        return PageRequest.of(page, size);
    }
    public static Pageable createPageRequest(int page, int size, String sortBy) {
        return PageRequest.of(page, size, Sort.by(sortBy));
    }
}
