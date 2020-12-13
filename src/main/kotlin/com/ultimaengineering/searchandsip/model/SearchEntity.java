package com.ultimaengineering.searchandsip.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "searchEngine")
public class SearchEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String url;
    private String metaData;
}
