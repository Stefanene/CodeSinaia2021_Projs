package endpoints;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import contexts.GuestContext;
import contexts.ServerContext;
import schemas.JsonStatus;

/**
 * Servlet implementation class IRGuest
 */
@WebServlet("/IRGuest")
public class IRGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ServerContext serverContext;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IRGuest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        serverContext = (ServerContext)(getServletContext().getAttribute("serverContext"));
     }
    
    /**
     * Handle all IRHost commands. I.e:
     * http://localhost:8080/InstantReaction/IRGuest?cmd=login
     * http://localhost:8080/InstantReaction/IRGuest?cmd=logout
     * http://localhost:8080/InstantReaction/IRGuest?cmd=status
     * http://localhost:8080/InstantReaction/IRGuest?cmd=answer
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        JsonStatus result = new JsonStatus();
        
        if (cmd == null) {
            result.Success= false;
            result.Message = "IRGuest_Error: (null) command";
        } else if (cmd.equalsIgnoreCase("login")) {
            result = doCmdLogin(request);
        } else if (cmd.equalsIgnoreCase("logout")) {
            result = doCmdLogout(request);
        } else if (cmd.equalsIgnoreCase("status")) {
            result = doCmdStatus(request);
        }  else if (cmd.equalsIgnoreCase("answer")) {
            result = doCmdAnswer(request);
        } else {
            result.Success= false;
            result.Message = "IRGuest_Error: command " + cmd + " is unsupported!";
        }
        
        String answer = (new Gson()).toJson(result);
        response.getWriter().append(answer);
	}

	   /**
     * Handle IRHost login: http://localhost:8080/InstantReaction/IRHost?cmd=login&name=username
     */
    private JsonStatus doCmdLogin(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        String name =  request.getParameter("name");
        JsonStatus result = new JsonStatus();
        
    	if(name==null|| name== "") {
            result.Success = false;
    		result.Message = "IRGuest Error: Missing name";
    	} else {
    	    GuestContext guestContext = new GuestContext(ipAddress, name);
    	    
    	    // try to login this member
    	    if (!serverContext.loginMember(guestContext)) {
    	        result.Success = false;
    	        result.Message = "IRGuest Error: Login failed!";
    	    } else {
    	        result.Success = true;
    	        result.Message = "Guest Logged in!";
    	    }
    	}
    	
        return result;
    }
    
    /**
     * Handle IRHost logout: http://localhost:8080/InstantReaction/IRHost?cmd=logout&name=username
     */
    private JsonStatus doCmdLogout(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        String name =  request.getParameter("name");
        JsonStatus result = new JsonStatus();

        if(name==null|| name== "") {
            result.Success = false;
            result.Message = "IRGuest Error: Missing name";
        } else {
            GuestContext guestContext = new GuestContext(ipAddress, name);
            
            // try to logout this member
            if (!serverContext.logoutMember(guestContext)) {
                result.Success = false;
                result.Message = "IRGuest Error: Logout failed!";
            } else {
                result.Success = true;
                result.Message = "Guest Logged out!";
            }
        }
        
        return result;
    }
    
    /**
     * Handle IRHost status: http://localhost:8080/InstantReaction/IRHost?cmd=status
     */
    private JsonStatus doCmdStatus(HttpServletRequest request) {
        JsonStatus result = new JsonStatus();
        result.Success = true;
        result.Message = "IRGuest_TODO: Processing status";
        return result;
    }
    
     /**
      * Handle IRHost clear: http://localhost:8080/InstantReaction/IRHost?cmd=clear
      */
     private JsonStatus doCmdAnswer(HttpServletRequest request) {
         JsonStatus result = new JsonStatus();
         result.Success = true;
         result.Message = "IRGuest_TODO: Processing answer";
         return result;
     }
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
