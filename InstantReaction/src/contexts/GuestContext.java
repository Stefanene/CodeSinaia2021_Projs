package contexts;

import schemas.JsonMemberContext;

public class GuestContext extends MemberContext {
    // Answer provided by this guest, if any (or null otherwise)
    private AnswerContext _answerContext;

    /**
     * GuestContext constructor is same as MemberConstructor.
     */
    public GuestContext(String ipAddress, String name) {
        super(ipAddress, name);
        _answerContext = null;
    }
    
    /**
     * Accessor for the answer.
     */
    public AnswerContext getAnswer() {
        return _answerContext;
    }
    
    /**
     * Mutator for the answer.
     * Set to (null) to erase the last answer provided by this guest.
     */
    public void setAnswer(AnswerContext answerContext) {
        _answerContext = answerContext;
    }
    
    @Override
    public String toString() {
        return "Guest " + super.toString();
    }
    
    /**
     * Returns the json container for this guest member.
     */
    @Override
    public JsonMemberContext toJson() {
        JsonMemberContext jsonGuestContext = super.toJson();
        jsonGuestContext.Role = "Guest";
        return jsonGuestContext;
    }

}
