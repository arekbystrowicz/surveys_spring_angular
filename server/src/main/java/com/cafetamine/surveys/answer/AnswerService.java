package com.cafetamine.surveys.answer;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.cafetamine.surveys.question.Question;


@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getById(Long id) {
        Optional<Answer> answer = this.answerRepository.findByIdAndIsAccessible(id, true);
        if (!answer.isPresent()) {
            // TODO exception
            throw new RuntimeException("404 question not found");
        }
        return answer.get();
    }

    public Iterable<Answer> getByQuestion(Question question) {
        return this.answerRepository.findAllByQuestionAndIsAccessible(question, true);
    }

    public Answer create(Answer answer, Question question) {
        // TODO adjust implementation to client
        answer.setQuestion(question);
        answer.setAccessible(true);

        return this.answerRepository.save(answer);
    }

    public Answer update(Long id, Answer updatedAnswer) {
        Answer answer = this.getById(id);

        String description = updatedAnswer.getDescription();
        if (!description.equals("")) {
            answer.setDescription(description);
        }

        return this.answerRepository.save(answer);
    }

    public Answer delete(Long id) {
        // TODO adjust implementation to client
        Answer answer = this.getById(id);
        answer.setAccessible(false);

        return this.answerRepository.save(answer);
    }

}
