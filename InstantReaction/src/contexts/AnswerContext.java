package contexts;

/**
 * Answer Context class, holding all data about an answer.
 * An answer is contextual to a question, identified by the question rolling ID.
 */
public class AnswerContext {
    // Initialize all fields to values reflecting a non-existent answer.
    private int _questionId = 0;
    private String _answerText = "";
    
    /**
     * Gets the Id of the question being answered.
     */
    public int getQuestionId() {
        return _questionId;
    }
    
    /**
     * Gets the text of the answer.
     */
    public String getText() {
        return _answerText;
    }
    
    /**
     * AnswerContext default constructor, modeling an answer which has not been given yet.
     */
    public AnswerContext(int questionId, String answerText) {
        _questionId = questionId;
        _answerText = answerText;
    }
}
