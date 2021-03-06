package com.webbanmatkinh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
	
	@Column(name = "username" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String userName;
	
	@Column(name = "password" , columnDefinition = "NVARCHAR(100) NOT NULL")
	private String password;
	
	@Column(name = "fullname" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String fullName;
	
	@Column(name = "resetPasswordToken" , columnDefinition = "NVARCHAR(100)")
	private String resetPasswordToken;
	
	@Column(name = "email" , columnDefinition = "NVARCHAR(50) NOT NULL")
	private String email;
	
	@Column(name = "phone" , columnDefinition = "NVARCHAR(20) NOT NULL")
	private String phone;
	
	@Column(name = "address" , columnDefinition = "NVARCHAR(500) NOT NULL")
	private String address;
	
	// khong cho phep xoa tai khoan, chi update status
	@Column(name = "status")
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid")
	private RoleEntity role;
	
	@OneToOne(mappedBy = "userid")
    private CartEntity cartid;
	
	@OneToMany(mappedBy = "user")
	private List<BillEntity> bills = new ArrayList<>();

	public List<BillEntity> getBills() {
		return bills;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public CartEntity getCartid() {
		return cartid;
	}

	public void setCartid(CartEntity cartid) {
		this.cartid = cartid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
