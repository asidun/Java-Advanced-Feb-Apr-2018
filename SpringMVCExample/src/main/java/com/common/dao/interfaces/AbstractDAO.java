package com.common.dao.interfaces;

import java.util.List;

public interface AbstractDAO<T> {
	T getById(int id);
	List<T> getAll();
	int insert(T obj);	
}
