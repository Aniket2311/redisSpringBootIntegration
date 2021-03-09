package com.aniket.springboot.redis.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.aniket.springboot.redis.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private HashOperations<String, String, User> hashOperations;

	@Autowired
	public UserDAOImpl(RedisTemplate<String, User> redisTemplate) {

		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void saveUser(final User user) {

		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public void updateUser(final User user) {

		saveUser(user);
	}

	@Override
	public User getById(final String userId) {

		return hashOperations.get("USER", userId);
	}

	@Override
	public Map<String, User> getAllUsers() {

		return hashOperations.entries("USER");
	}

}
