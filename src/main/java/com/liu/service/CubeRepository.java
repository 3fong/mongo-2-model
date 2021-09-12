package com.liu.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CubeRepository extends CrudRepository<Cube,String> {
}
