package com.aniket.springboot.redis.dao;

import java.util.Map;

import com.aniket.springboot.redis.entity.User;

public interface UserDAO {

	void saveUser(final User user);

	void updateUser(final User user);

	User getById(final String userId);

	Map<String, User> getAllUsers();
}
