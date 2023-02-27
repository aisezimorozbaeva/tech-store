package com.ais.techstore.service.impl;

import com.ais.techstore.model.Description;
import com.ais.techstore.repository.DescriptionRepository;
import com.ais.techstore.service.DescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    @Override
    public void save(Description description) {
        descriptionRepository.save(description);
    }

    @Override
    public void deleteById(long id) {
        descriptionRepository.deleteById(id);
    }
}
