package com.ultimaengineering.searchandsip.controller;

import com.ultimaengineering.searchandsip.controller.dto.SearchResultsDTO;
import com.ultimaengineering.searchandsip.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(params = { "page", "size" })
    public Page<SearchResultsDTO> getSearch(@RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(value = "size", defaultValue = "25") int size, UriComponentsBuilder uriBuilder,
                                               HttpServletResponse response) {
        Page<SearchResultsDTO> resultPage = searchService.findPaginated(size, page, Sort.unsorted());
        if (page > resultPage.getTotalPages()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No results found for that search query");
        }

        return null;
    }

}
