package com.infosys.msproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.msproject.dto.AddressDTO;
import com.infosys.msproject.entity.Address;
import com.infosys.msproject.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addrRepo;
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	
	public void addAddress(AddressDTO addressDTO, String userId) {
		logger.info("Inside add address service");
		Address adr= new Address();
				addressDTO.createEntity(adr);
		adr.setUserId(userId);
		addrRepo.save(adr);
	}


	public AddressDTO getAddress(String userId, Long addressId) {
		logger.info("Inside get address by Id service");
		Optional<Address> adrOpt=addrRepo.findById(addressId);
		
		if (adrOpt.isPresent()){
			AddressDTO addrDTO= new AddressDTO(adrOpt.get());
			return addrDTO;
		}else {
			return null;
		}
		
		
	}


	public List<AddressDTO> getAddressByUserId(String userId) {
		// TODO Auto-generated method stub
		logger.info("Inside get address by user id service");
		List<Address> adrList=addrRepo.findByUserId(userId);
		List<AddressDTO> adrDtoList=new ArrayList<AddressDTO>();
		for(Address adr: adrList) {
			AddressDTO adrDto=new AddressDTO(adr);
			adrDtoList.add(adrDto);
		}
		
		return adrDtoList;
	}


	public void modifyAddress(AddressDTO addressDTO, String userId,Long addressId) {
		logger.info("Inside modify address service");
		Optional<Address> adrDBOpt=addrRepo.findById(addressId);
		if (adrDBOpt.isPresent()) {
			Address adrDb=adrDBOpt.get();
			if(adrDb.getUserId().equals(userId)) {
				addressDTO.createEntity(adrDb);			
				addrRepo.save(adrDb);
			}
		}
		
		
		
	}


	public void deleteAddress(Long addressId, String userId) {
		logger.info("Inside delete address service");
		Optional<Address> adrDBOpt=addrRepo.findById(addressId);
		if (adrDBOpt.isPresent()) {
			Address adrDb=adrDBOpt.get();
			if(adrDb.getUserId().equals(userId)) {
				addrRepo.deleteById(addressId);
			}
		}
		
	}
}
