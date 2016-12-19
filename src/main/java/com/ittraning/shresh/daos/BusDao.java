package com.ittraning.shresh.daos;

import java.util.List;

import com.ittraning.shresh.models.Bus;

public interface BusDao {
	public Long insert(Bus bus);
	public List<Bus> getAll();
	public Bus get(Long id);
}
