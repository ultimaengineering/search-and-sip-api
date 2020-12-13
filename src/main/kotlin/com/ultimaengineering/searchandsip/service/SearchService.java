package com.ultimaengineering.searchandsip.service;

import com.ultimaengineering.searchandsip.controller.dto.SearchResultsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    public Page<SearchResultsDTO> findPaginated(Integer size, Integer page, Sort sort) {
        Pageable pageRequest = createPageRequest(size, page, sort);

    }

    private Pageable createPageRequest(Integer size, Integer page, Sort sort) {
        return PageRequest.of(size, page, sort);
    }
}
