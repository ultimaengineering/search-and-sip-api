package com.ultimaengineering.searchandsipapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import com.ultimaengineering.searchandsipapi.controller.dto.SearchResult
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/")
class SearchController {

    @GetMapping("search")
    fun search(@RequestParam("q") query: String?) : Flux<SearchResult> {
        var result = SearchResult()
        var list = ArrayList<SearchResult>()
        list.add(result)
        return Flux.fromIterable(list)
    }
}