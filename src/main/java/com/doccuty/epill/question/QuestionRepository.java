package com.doccuty.epill.question;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doccuty.epill.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
