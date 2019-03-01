package in.daypay.poc.dao;

import in.daypay.poc.beans.User;

public interface UserRepository {

	/**
	 * Get user by username and password
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserByUsername(String username, String password);
	
	/**
	 * Save user
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * update user
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * Find user by userId
	 * @param userId
	 * @return
	 */
	public User find(Integer userId);
}
