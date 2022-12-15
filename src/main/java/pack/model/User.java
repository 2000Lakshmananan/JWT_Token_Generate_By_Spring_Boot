package pack.model;


import jakarta.persistence.*;
import pack.common.Constant;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String userType = Constant.USER_TYPE.NORMAL;
	private String password;
	private Boolean isActive;
	private String loginAt;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String gender, String email, String phone, String userType, String password,
			Boolean isActive, String loginAt) {
		super();
		Id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.userType = userType;
		this.password = password;
		this.isActive = isActive;
		this.loginAt = loginAt;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getLoginAt() {
		return loginAt;
	}
	public void setLoginAt(String loginAt) {
		this.loginAt = loginAt;
	}
	
	@PrePersist
	public void before() {
		
//		create at and update at
		
	}
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", userType=" + userType + ", password=" + password + ", isActive=" + isActive + ", loginCount="
				+ ", loginAt=" + loginAt + ", createAt="+ ", updatedAt=" + "]";
	}

}
