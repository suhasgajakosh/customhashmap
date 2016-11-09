package com.cloud.hashmap.repository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.hashmap.model.ServiceBinding;

public interface ServiceBindingRepository extends CrudRepository<ServiceBinding,String> {
}
