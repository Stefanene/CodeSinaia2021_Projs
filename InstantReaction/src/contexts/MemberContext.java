package contexts;

import schemas.JsonMemberContext;

/**
 * Member Context class holding all data of one member (Host or Guest)
 */
public abstract class MemberContext {
    // Client IP Address of the member
    private String ipAddress;
    // Member name
    private String name;
    
    /**
     * MemberContext for requires the member IP, member name
     */
    public MemberContext(String ipAddress, String name) {
        this.ipAddress = ipAddress;
        this.name = name;
    }
    
    /**
     * Accessor for the member IP.
     */
    public String getIP() {
        return ipAddress;
    }
    
    /**
     * Accessor for the member name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns a description summarizing the member data
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getIP(), getName());
    }
    
    /**
     * Returns the json container for this member
     */
    public JsonMemberContext toJson() {
        JsonMemberContext jsonMemberContext = new JsonMemberContext();
        jsonMemberContext.IPAddress = ipAddress;
        jsonMemberContext.Name = name;
        return jsonMemberContext;
    }
}
