package core;

public class AnswerValidator {
    public static String validateAnswer(Question question, Answer answer) {
        if (answer.getText().isEmpty()) {
            return "Answer text cannot be empty";
        }
        if (answer.getText().length() > 2000) {
            return "Answer text cannot exceed 2000 characters";
        }
        
        // Check for duplicate answers
        for (int i = 0; i < question.getAnswers().size(); i++) {
            if (question.getAnswers().get(i).getText().equals(answer.getText())) {
                return "This answer already exists";
            }
        }
        
        return "";
    }
}