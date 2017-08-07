package com.doccuty.epill.iteminvocation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doccuty.epill.user.User;

@Repository
@Transactional
public interface ItemInvocationRepository extends JpaRepository<ItemInvocation, Long> {

	@Query("SELECT new ItemInvocation(d, MAX(invocation.timestamp), COUNT(*)) FROM ItemInvocation invocation "
			+ "JOIN invocation.drug d "
			+ "WHERE invocation.user = :user "
			+ "GROUP BY d")
	List<ItemInvocation> findInvocedDrugs(@Param("user") User user);
	
	List<ItemInvocation> findByUser(User user);
}
