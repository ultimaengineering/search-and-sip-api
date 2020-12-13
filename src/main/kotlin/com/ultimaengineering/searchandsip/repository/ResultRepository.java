package com.ultimaengineering.searchandsip.repository;

import com.ultimaengineering.searchandsip.model.SearchEntity;
import io.micrometer.core.instrument.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface ResultRepository extends ElasticsearchRepository<SearchEntity, UUID> {
    Page<SearchEntity> findSearchEntityByDescription(String search);
}
