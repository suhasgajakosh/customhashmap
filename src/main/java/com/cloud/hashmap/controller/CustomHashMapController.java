package com.cloud.hashmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.hashmap.service.CustomHashMapService;

@RestController
public class CustomHashMapController {

	@SuppressWarnings("rawtypes")
	@Autowired
	CustomHashMapService service;

	@RequestMapping(value = "/hashmap/{key}", method = RequestMethod.PUT)
	public ResponseEntity<String> put(@PathVariable("key") String key, @RequestBody String value) {
		service.put(key, value);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/hashmap/{key}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("key") String key) {
		Object result = service.get(key);
		if (null != result) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/hashmap/{key}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("key") String key) {
		Object result = service.get(key);
		if (null != result) {
			service.remove(key);
			return new ResponseEntity<>("{}", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("{}", HttpStatus.GONE);
		}
	}

}