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

    public Answer create(Answer answer) {
        // TODO adjust implementation to client
        return this.answerRepository.save(answer);
    }

    public Answer update(Answer answer) {
        // TODO adjust implementation to client
        return this.answerRepository.save(answer);
    }

    public Answer delete(Long id) {
        // TODO adjust implementation to client
        Answer answer = this.getById(id);
        this.answerRepository.delete(answer);

        return answer;
    }

}
