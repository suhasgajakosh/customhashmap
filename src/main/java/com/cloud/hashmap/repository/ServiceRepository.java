package com.cloud.hashmap.repository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.hashmap.model.Service;

public interface ServiceRepository extends CrudRepository<Service, String> {
}
