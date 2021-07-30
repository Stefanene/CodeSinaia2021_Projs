package endpoints;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import contexts.HostContext;
import contexts.ServerContext;
import schemas.JsonStatus;

/**
 * Servlet implementation class IRHost
 */
@WebServlet("/IRHost")
public class IRHost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ServerContext serverContext;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IRHost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
     public void init() {
        serverContext = (ServerContext)(getServletContext().getAttribute("serverContext"));
     }

	/**
	 * Handle all IRHost commands. I.e:
	 * http://localhost:8080/InstantReaction/IRHost?cmd=login
	 * http://localhost:8080/InstantReaction/IRHost?cmd=logout
	 * http://localhost:8080/InstantReaction/IRHost?cmd=status
	 * http://localhost:8080/InstantReaction/IRHost?cmd=ask
	 * http://localhost:8080/InstantReaction/IRHost?cmd=clear
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
        JsonStatus result = new JsonStatus();
		
		if (cmd == null) {
            result.Success= false;
            result.Message = "IRHost_Error: (null) command";
		} else if (cmd.equalsIgnoreCase("login")) {
            result = doCmdLogin(request);
        } else if (cmd.equalsIgnoreCase("logout")) {
		    result = doCmdLogout(request);
		} else if (cmd.equalsIgnoreCase("status")) {
            result = doCmdStatus(request);
        }  else if (cmd.equalsIgnoreCase("ask")) {
            result = doCmdAsk(request);
        }  else if (cmd.equalsIgnoreCase("clear")) {
            result = doCmdClear(request);
        } else {
            result.Success= false;
            result.Message = "IRHost_Error: command " + cmd + " is unsupported!";
        }
		
        String answer = (new Gson()).toJson(result);
        response.getWriter().append(answer);
	}
	
	/**
	 * Handle IRHost login: http://localhost:8080/InstantReaction/IRHost?cmd=login&name=username&password=password
	 */
	private JsonStatus doCmdLogin(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
		String name =  request.getParameter("name");
	    String password =  request.getParameter("password");
        JsonStatus result = new JsonStatus();
	    
	    if(name ==  null || password == null) {
            result.Success = false;
            result.Message = "IRHost_Error:Missing Credentials!";
	    } else {
           HostContext hostContext = new HostContext(ipAddress, name, password);
            
            // try to login this member
            if (!serverContext.loginMember(hostContext)) {
                result.Success = false;
                result.Message = "IRHost Error: Login failed!";
            } else {
                result.Success = true;
                result.Message = "Host Logged in!";
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
        
        if(name ==  null) {
            result.Success = false;
            result.Message = "IRHost_Error:Missing Credentials!";
        } else {
           HostContext hostContext = new HostContext(ipAddress, name);
            
            // try to logout this member
            if (!serverContext.logoutMember(hostContext)) {
                result.Success = false;
                result.Message = "IRHost Error: Logout failed!";
            } else {
                result.Success = true;
                result.Message = "Host Logged out!";
            }
        }
        
        return result;
    }
    
    /**
     * Handle IRHost status: http://localhost:8080/InstantReaction/IRHost?cmd=status
     */
    private JsonStatus doCmdStatus(HttpServletRequest request) {
        return serverContext.toJson();
    }
    
    /**
      * Handle IRHost ask: http://localhost:8080/InstantReaction/IRHost?cmd=ask
      */
     private JsonStatus doCmdAsk(HttpServletRequest request) {
         JsonStatus result = new JsonStatus();
         result.Success = true;
         result.Message = "IRHost_TODO: Processing ask";
         return result;
     }
     
     /**
      * Handle IRHost clear: http://localhost:8080/InstantReaction/IRHost?cmd=clear
      */
     private JsonStatus doCmdClear(HttpServletRequest request) {
         JsonStatus result = new JsonStatus();
         result.Success = true;
         result.Message = "IRHost_TODO: Processing clear";
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
