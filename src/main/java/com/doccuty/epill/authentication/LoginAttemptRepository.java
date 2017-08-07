package com.doccuty.epill.authentication;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doccuty.epill.model.LoginAttempt;

@Repository
@Transactional
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {

}
