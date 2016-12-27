package com.ittraning.shresh.daos;

import java.util.List;

import com.ittraning.shresh.models.Location;

public interface LocationDao {
	public Long insert(Location location);
	public List<Location> getAll();
	public Location get(Long id);
	public void insertUpdate(Location location);
	public void delete(Long id);
}
