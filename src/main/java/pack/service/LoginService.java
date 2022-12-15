package pack.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.LoginRequestDTO;
import pack.dto.SignupRequestDTO;
import pack.model.User;
import pack.repository.UserRepository;
import pack.utils.JwtUtil;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JwtUtil jwtUtil;

	public APIResponse signup(SignupRequestDTO signupRequestDTO) {
		
		APIResponse apiResponse = new APIResponse();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String sss=dtf.format(now);
		   
//		apiResponse.setData("its working");
		
//		validation
		
//		DTO to entity
		
		User userEntity = new User();
		
		userEntity.setName(signupRequestDTO.getName());
		userEntity.setEmail(signupRequestDTO.getEmail());
		userEntity.setIsActive(Boolean.TRUE);
		userEntity.setGender(signupRequestDTO.getGender());
		userEntity.setPassword(signupRequestDTO.getPassword());
		userEntity.setPhone(signupRequestDTO.getPhone());
		userEntity.setLoginAt(sss);
		
//		store Entity
		
		userEntity = userRepo.save(userEntity);
		
//		return
//		apiResponse.setData("users created successfully");
		apiResponse.setData(userEntity);
		
		return apiResponse;
	}

	public APIResponse login(LoginRequestDTO loginRequestDTO) {
		
		APIResponse apiResponse = new APIResponse();
		
//		validation
		
//		verify user exist with given email and password
		
//		User user = userRepo.findOneByEmailAndPassword(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
		List<User> u=(List<User>) userRepo.findAll();
		System.out.println(u.toString());
		System.out.println("Coming Email "+loginRequestDTO.getEmail());
		for(User u1:u)
		{
			System.out.println("U1"+u1.getEmail());
			if(u1.getEmail().equals(loginRequestDTO.getEmail()))
			{	
				if(u1.getPassword().equals(loginRequestDTO.getPassword()))
				{
					System.out.println("Finded");
					String token = jwtUtil.generateJwt(u1);
					apiResponse.setData(token);
					return apiResponse;
				}
				else
				{
					apiResponse.setData("Oops, email & password does not matched.");
					return apiResponse;
				}
				
			}
		}
		apiResponse.setData(loginRequestDTO.getEmail()+" - Email not found. Please Signup");
		return apiResponse;
		
//		apiResponse.setData("Welcome");
//		return apiResponse;
		
//		System.out.println(user.toString());
		
//		response
//		if(user == null) {
//			apiResponse.setData("user login failed");
//			return apiResponse;
//		}
		
//		jwt generate
		
//		String token = jwtUtil.generateJwt(user);
//		apiResponse.setData(token);
//		
//		return apiResponse;
	}
	

}
