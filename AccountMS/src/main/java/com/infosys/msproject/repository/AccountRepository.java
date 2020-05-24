package com.infosys.msproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.msproject.entity.UserInfo;

public interface AccountRepository extends JpaRepository<UserInfo, String> {

}
