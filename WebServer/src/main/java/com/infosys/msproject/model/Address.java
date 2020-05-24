package com.infosys.msproject.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Address { 

	private Long addressId;
	@NotEmpty(message = "{address.invalid.address.empty}")
	@Size(min=10, max = 50, message = "{address.invalid.address.length}")
	private String address;
	@NotEmpty(message = "{address.invalid.city.empty}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message="{account.invalid.city.character}" )
    private String city;
	@NotEmpty(message = "{address.invalid.state.empty}")
    private String state;
	@NotEmpty(message = "{address.invalid.pincode.empty}")
	@Size(min = 6,max=6, message="{address.invalid.pincode.length}")
	@Pattern(regexp = "^[0-9]*$", message="{account.invalid.pincode.character}" )
    private String pincode;
		@NotEmpty(message = "{address.invalid.phoneNumber.empty}")
	@Size(min = 10,max=10, message="{address.invalid.phoneNumber.length}")
	@Pattern(regexp = "^[0-9]*$", message="{account.invalid.phoneNumber.character}" )
	private String phoneNumber;
    
    
    public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



}
