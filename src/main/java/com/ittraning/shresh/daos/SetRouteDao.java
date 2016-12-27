package com.ittraning.shresh.daos;

import java.util.List;

import com.ittraning.shresh.models.SetRoute;


public interface SetRouteDao {
	public Long insert(SetRoute setroute);
	public List<SetRoute> getAll();
	public void insertUpdate(SetRoute setroute);
	public void delete(Long id);
	public SetRoute get(Long id);
}
