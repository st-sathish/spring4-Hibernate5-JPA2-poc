package in.daypay.poc.endpoint;

import in.daypay.poc.beans.User;
import in.daypay.poc.models.BaseResponse;
import in.daypay.poc.models.UserResponse;
import in.daypay.poc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

@RestController
@RequestMapping("/api/")
public class UserRestController {

	@Autowired
	public UserService userService;
	
	/**
	 * Authenticate user credentials
	 * @return
	 */
	@PostMapping(value = "v1/users/authenticate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> authenticateUser(@RequestBody User user) {
		UserResponse userResponse = userService.findUserByUsername(user.getUsername(), user.getPassword());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	/**
	 * Save user
	 */
	@PostMapping(value = "v1/users")
	public ResponseEntity<BaseResponse> saveUser(@RequestBody User user) {
		userService.saveOrUpdateUser(user);
		BaseResponse res = new BaseResponse();
		res.setCode(HttpStatus.CREATED.value());
		res.setMessage("Successfully Created");
		return new ResponseEntity<BaseResponse>(res, HttpStatus.CREATED);
	}
	
	/**
	 * Update user
	 */
	@PutMapping(value = "v1/users")
	public ResponseEntity<BaseResponse> updateUser(@RequestBody User user) {
		userService.saveOrUpdateUser(user);
		BaseResponse res = new BaseResponse();
		res.setCode(HttpStatus.OK.value());
		res.setMessage("Successfully Updated");
		return new ResponseEntity<BaseResponse>(res, HttpStatus.OK);
	}
	
	/**
	 * Delete user
	 */
	@DeleteMapping(value = "v1/users")
	public void deleteUser(@RequestBody User user) {
		
	}
	
	/**
	 * Get user
	 */
	@GetMapping(value = "v1/users/:id")
	public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
		UserResponse userResponse = userService.findUser(id);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
}