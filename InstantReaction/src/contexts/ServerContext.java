package contexts;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import schemas.JsonServerStatus;

public class ServerContext {
    // Dictionary indexing (by their key) all the members, guests or hosts, currently logged in
    private ConcurrentHashMap<String, MemberContext> audienceMap;
    
    // Default usernames & passwds
    private static final int DEFAULT_HOST_MEMBERS_NUM = 3;
    private ConcurrentHashMap<String, String> defaultHostMembers;
    
    // Question outstanding on the server, if any (or null otherwise)
    private QuestionContext questionContext;
	
	public ServerContext() {
        audienceMap = new ConcurrentHashMap<String, MemberContext>();
        
        generateDefaultUsernames();
        questionContext = null;
	}
	
	/* 
	 * This method generates the following usernames & pswds:
	 * 
	 * ana0
	 * 0
	 * 
	 * ana1
	 * 1
	 * 
	 * ana2
	 * 2
	 * 
	 */
    public void generateDefaultUsernames()
    {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			
	        defaultHostMembers = new ConcurrentHashMap<String, String>();
	        
			String usrname = "ana";
			
	        for (int i = 0; i < DEFAULT_HOST_MEMBERS_NUM; i++)
	        {
				String password = "" + i;
	        	byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));	    	
	        	String base64EncodedPassword = Base64.getEncoder().encodeToString(hashedPassword);
	        	
	        	defaultHostMembers.put(usrname + i, base64EncodedPassword);
	        }
	        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    public String toString() {
        String answer = String.format("Login count: %d", audienceMap.size());
        
        // if there's any outstanding question, add it's first few characters to the answer
        if (questionContext != null) {
            answer += "<br>";
            answer += String.format("Question: %s...?", questionContext.getText().substring(0, 5));
        }
		
		//iterate through audienceMap building an output showing all logins on server.
		for(Map.Entry<String, MemberContext> member : audienceMap.entrySet()) {
		    MemberContext memberContext = member.getValue();
		    answer += "<br>";
		    answer += String.format("%s", memberContext);
		}
		
		return answer;
	}
    
    /**
     * Creates a JsonStatus schema object reflecting the current server context.
     * @return
     */
    public JsonServerStatus toJson() {
        JsonServerStatus jsonServerStatus = new JsonServerStatus();
        jsonServerStatus.Message = String.format("Login count: %d", audienceMap.size());
        
        // if there's any outstanding question, add it's first few characters to the answer
        if (questionContext != null) {
            jsonServerStatus.Message += "<br>";
            jsonServerStatus.Message += String.format("Question: %s...?", questionContext.getText().substring(0, 5));
        }
        
        //iterate through audienceMap building an output showing all logins on server.
        for(Map.Entry<String, MemberContext> member : audienceMap.entrySet()) {
            MemberContext memberContext = member.getValue();
            jsonServerStatus.Members.add(memberContext.toJson());
        }
        
        jsonServerStatus.Success = true;
        return jsonServerStatus;
    }
    
    /**
     * Returns the full member context from the audience map
     */
    public MemberContext getMember(MemberContext memberContext) {
        MemberContext memberInAudience = null;
        if (memberContext != null) {
            memberInAudience = audienceMap.get(memberContext.getName());
        }
        
        return memberInAudience;
    }
    
    public boolean isValidMember(String username, String password) {
    	String targetPassword = defaultHostMembers.get(username);
    	if (targetPassword != null)
    	{  		
    		if (password.equals(targetPassword))
    		{
    			System.out.println("Matching password");
    			return true;
    		}
    		else
    		{
    			System.out.println("Wrong password for user:" + username);
    		}
    	}
    	return false;
    }
	
	public boolean loginMember(MemberContext memberContext) {
	    boolean success = true;
	    
	    // if logging in a Host check if its name & password match the configured set
	    if (memberContext instanceof HostContext) {
	        String hostPassword = ((HostContext)memberContext).getPassword();
	        success = isValidMember(memberContext.getName(), hostPassword);
	    }
	    
	    // if success so far, check the member is not already logged in
	    if (success) {
	        success = (getMember(memberContext) == null);
	    }
	    
	    // if all good so far, login the member
	    if (success) {
	        audienceMap.put(memberContext.getName(), memberContext);
	    }
	    
		return success;
	}
	
	public boolean logoutMember(MemberContext memberContext) {
	    // check the member is already in the audience and its IP matches. If so, remove it.
	    MemberContext currentMember = getMember(memberContext);
	    if (currentMember != null && currentMember.getIP().equals(memberContext.getIP())) {
	        audienceMap.remove(currentMember.getName());
	        return true;
	    }
	    
		return false;
	}
}
