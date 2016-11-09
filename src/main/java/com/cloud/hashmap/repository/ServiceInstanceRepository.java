package com.cloud.hashmap.repository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.hashmap.model.ServiceInstance;

/**
 * Created by pivotal on 6/26/14.
 */
public interface ServiceInstanceRepository extends CrudRepository<ServiceInstance, String> {
}
