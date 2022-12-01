package com.example.excersicethree.repository;

import com.example.excersicethree.document.Text;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface TextRepository extends ElasticsearchRepository<Text, String> {

    List<Text> findAllByTextContainingIgnoreCase(String text);

}
