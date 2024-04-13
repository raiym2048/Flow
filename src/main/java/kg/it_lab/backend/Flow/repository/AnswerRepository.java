package kg.it_lab.backend.Flow.repository;

import kg.it_lab.backend.Flow.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "delete from answer a where " +
            "a.answer_question= ?1 and " +
            "a.answer_text= ?2", nativeQuery = true)
    void findByAnswerQuestionAndAnswerText(String answerQuestion, String answerText);

    Answer findFirstByOrderByIdDesc();

}
