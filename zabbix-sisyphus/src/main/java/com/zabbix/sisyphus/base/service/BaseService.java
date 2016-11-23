package com.zabbix.sisyphus.base.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.zabbix.sisyphus.base.repository.BaseRepository;


public class BaseService<T> {

	private BaseRepository<T> repository;

	public T load(Long id) {
		return repository.findOne(id);
	}
	
	public List<T> loadAllData() {
		return repository.findAll();
	}

	public Page<T> getPages(Specification<T> buildSpecification, PageRequest buildPageRequest) {
		return repository.findAll(buildSpecification, buildPageRequest);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public void delete(Long[] ids) {
		for (Long id : ids) {
			repository.delete(id);
		}
	}
	
	public void saveBatch(List<T> entities){
		repository.save(entities);
	}
	
	public void saveOrUpdate(T t) {
		repository.save(t);
	}

	public void setRepository(BaseRepository<T> repository) {
		this.repository = repository;
	}

	
}
