package com.zenvofurniture.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenvofurniture.entity.UserEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Long>{
	  Optional<UserEntity> findByUserName(String userName);
}
