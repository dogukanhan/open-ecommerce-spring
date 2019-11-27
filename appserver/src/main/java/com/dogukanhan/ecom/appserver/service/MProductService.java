package com.dogukanhan.ecom.appserver.service;

import com.dogukanhan.ecom.appserver.entity.MProduct;
import com.dogukanhan.ecom.appserver.exception.ResourceNotFoundException;
import com.dogukanhan.ecom.appserver.repository.MProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MProductService {

    private final MProductRepository repository;

    public MProduct findOneById(Long id) {
        return repository.findOne(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

}

