package com.ittraning.shresh.daos;

import java.util.List;

import com.ittraning.shresh.models.Users;

public interface UsersDao {
	public Long insert(Users users);
	public List<Users> getAll();
	public Users get(Long id);
	public boolean validateuser(Users users);
	public Users get(Users users);
	public void insertUpdate(Users users);
}
