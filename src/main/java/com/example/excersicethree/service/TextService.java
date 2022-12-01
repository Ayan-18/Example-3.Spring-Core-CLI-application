package com.example.excersicethree.service;

import com.example.excersicethree.document.Text;
import com.example.excersicethree.repository.TextRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {
    private final TextRepository textRepository;

    @Autowired
    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public void save(final Text text) {
        textRepository.save(text);
    }

    public List<Text> search(String text) {
        return textRepository.findAllByTextContainingIgnoreCase(text);
    }
}
