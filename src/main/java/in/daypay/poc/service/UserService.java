package in.daypay.poc.service;

import in.daypay.poc.beans.User;
import in.daypay.poc.models.UserResponse;

public interface UserService {

	/**
	 * Authenticate new user by username and password
	 * @param username
	 * 		username
	 * @param password
	 * 		password
	 * @return
	 * 		user object
	 */
	public UserResponse findUserByUsername(String username, String password);

	/**
	 * Create or Update user
	 * @param user
	 */
	public void saveOrUpdateUser(User user);

	/**
	 * Find user by user id
	 * @param userId
	 * @return
	 */
	public UserResponse findUser(Integer userId);

	/**
	 * Delete User by userId
	 * @param userId
	 */
	public void deleteUser(Integer userId);
}
