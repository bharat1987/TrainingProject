package com.msproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msproject.entity.UserInfo;

public interface AccountRepository extends JpaRepository<UserInfo, String> {

}
