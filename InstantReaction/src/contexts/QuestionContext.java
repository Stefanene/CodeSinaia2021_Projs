package contexts;

/**
 * Question Context class, holding all data about a question.
 * A question has a rolling Id, a type and a text. An empty type reflects a non-existent question.
 */
public class QuestionContext {
    // Initialize all fields to values reflecting a non-existent question.
    private int _questionId = 0;
    private String _questionType = "";
    private String _questionText = "";
    
    public QuestionContext(int questionId, String questionType, String questionText) {
        _questionId = questionId;
        _questionType = questionType;
        _questionText = questionText;
    }
    
    /**
     * Gets the Id of this question.
     */
    public int getId() {
        return _questionId;
    }
    
    /**
     * Gets the type of this question: "Choice", "Range" or "FreeText"
     * @return
     */
    public String getType() {
        return _questionType;
    }
    
    /**
     * Gets the actual text content of this question.
     */
    public String getText() {
        return _questionText;
    }
}
