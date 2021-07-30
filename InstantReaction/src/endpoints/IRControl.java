package endpoints;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import contexts.ServerContext;
import schemas.JsonStatus;

/**
 * Servlet implementation class IRControl
 */
@WebServlet("/IRControl")
public class IRControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private ServerContext serverContext;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IRControl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
       serverContext = (ServerContext)(getServletContext().getAttribute("serverContext"));
    }
    
    /**
     * Handle all IRControl commands. I.e:
     * http://localhost:8080/InstantReaction/IRControl?cmd=status
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        JsonStatus result = new JsonStatus();
        
        if (cmd == null) {
            result.Success= false;
            result.Message = "IRControl_Error: (null) command";
        } else if (cmd.equalsIgnoreCase("status")) {
            result = doCmdStatus(request);
        }  else {
            result.Success= false;
            result.Message = "IRControl_Error: command " + cmd + " is unsupported!";
        }
        
        String answer = (new Gson()).toJson(result);
        response.getWriter().append(answer);
    }
    
    /**
     * Handle IRControl status: http://localhost:8080/InstantReaction/IRControl?cmd=status
     */
    private JsonStatus doCmdStatus(HttpServletRequest request) {
        // return "IRControl_TODO: Processing status";
        return serverContext.toJson();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}