package com.ais.techstore.service;

import com.ais.techstore.model.Description;

public interface DescriptionService {
    void save(Description description);
    void deleteById(long id);
}
