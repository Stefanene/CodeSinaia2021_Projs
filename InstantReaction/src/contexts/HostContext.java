package contexts;

import schemas.JsonMemberContext;

public class HostContext extends MemberContext {

    // Host password
    private String _password;
    
    // Question asked by this host, if any (or null otherwise)
    private QuestionContext _questionContext;
 
    /**
     * HostContext constructor is same as MemberContext constructor but adds to it the host password.
     */
    public HostContext(String ipAddress, String name, String password) {
        super(ipAddress, name);
        _password = password;
        _questionContext = null;
    }
    
    /**
     * HostContext constructor for the situation the password it's not known (i.e. when logging out).
     */
    public HostContext(String ipAddress, String name) {
        super(ipAddress, name);
        _password = null;
        _questionContext = null;
    }
    
    /**
     * Accessor for the password.
     */
    public String getPassword() {
        return _password;
    }
    
    /**
     * Accessor for the question.
     */
    public QuestionContext getQuestion() {
        return _questionContext;
    }
    
    /**
     * Mutator for the question.
     * Set to (null) to erase the last question asked by this host.
     */
    public void setQuestion(QuestionContext questionContext) {
        _questionContext = questionContext;
    }
    
    @Override
    public String toString() {
        return "Host " + super.toString();
    }
    
    /**
     * Returns the json container for this host member.
     */
    @Override
    public JsonMemberContext toJson() {
        JsonMemberContext jsonHostContext = super.toJson();
        jsonHostContext.Role = "Host";
        return jsonHostContext;
    }
}