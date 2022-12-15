package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pack.dto.LoginRequestDTO;
import pack.dto.SignupRequestDTO;
import pack.service.APIResponse;
import pack.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	public LoginService loginService;

	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUp(@RequestBody SignupRequestDTO signupRequestDTO)
	{
		APIResponse apiResponse = loginService.signup(signupRequestDTO);
		
		return ResponseEntity.
				status(apiResponse.getStatus())
				.body(apiResponse);
	}
	
	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO)
	{
		APIResponse apiResponse = loginService.login(loginRequestDTO);
		
		return ResponseEntity.
				status(apiResponse.getStatus())
				.body(apiResponse);
	}
	
}
