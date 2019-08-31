package com.doccuty.epill.userdrugplan;

import com.doccuty.epill.iteminvocation.ItemInvocation;
import com.doccuty.epill.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDrugPlanRepository extends JpaRepository<UserDrugPlan, Long> {

	/**
	 * find all planned drugs for user
	 *
	 * @param user
	 * @return
	 */
	List<UserDrugPlan> findByUser(User user);
}
