package in.daypay.poc.service;

import in.daypay.poc.beans.User;
import in.daypay.poc.dao.UserRepository;
import in.daypay.poc.models.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserResponse findUserByUsername(String username, String password) {
		User user = userRepository.getUserByUsername(username, password);
		UserResponse res = new UserResponse();
		return res;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		if(user.getId() == null) {
			userRepository.save(user);
			return;
		}
		User user1 = userRepository.find(user.getId());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		userRepository.update(user1);
	}

	@Override
	public UserResponse findUser(Integer userId) {
		User user = userRepository.find(userId);
		UserResponse res = new UserResponse();
		return res;
	}

	@Override
	public void deleteUser(Integer userId) {
		
	}

}
