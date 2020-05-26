package com.msproject.dto;

import com.msproject.model.Address;

public class AddressDTO {

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", phoneNumber=" + phoneNumber + "]";
	}
	private Long addressId;
	private String address;
    private String city;
    private String state;
    
    public AddressDTO() {} 
    
    
    public AddressDTO(Address address) {
    	this.addressId=address.getAddressId();
    	this.address=address.getAddress();
    	this.city=address.getCity();
    	this.state=address.getState();
    	this.phoneNumber=address.getPhoneNumber();
    	this.pincode=address.getPincode();
    }
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

	private String pincode;
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
	private String phoneNumber;
	
	
	public void createEntity(Address adr) {
		adr.setAddressId(this.getAddressId());
    	adr.setAddress(this.getAddress());
    	adr.setCity(this.getCity());
    	adr.setState(this.getState());
    	
    	adr.setPhoneNumber(this.getPhoneNumber());
    	adr.setPincode(this.getPincode());
    	
    }
	
	
}
