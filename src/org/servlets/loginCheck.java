package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;
import org.beans.User;
import org.logg.RunInvLogger;
import org.service.LoginService;
import org.service.LoginServiceimpl;

/**
 * Servlet implementation class loginCheck
 */
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		 out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Invalid Request</title>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\"> <b> Invalid Url Accessed<br>Please  <a href='login.jsp'>Login Again</a>");
		    out.println("</body>");
		    out.println("</html>");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try{
		PrintWriter out1 = response.getWriter();
		HttpSession loginSession=request.getSession();
		User loginUser=new User();
		
		loginUser.setEmail(request.getParameter("userid"));
		loginUser.setPassWord(request.getParameter("password"));
		LoginServiceimpl  loh=new LoginServiceimpl();
	if(	loh.checkLogin(loginUser)){
	
	User loSessionUser=loh.getUserLogged(loginUser.getEmail(), loginUser.getPassWord());
	loginSession.setAttribute("user", loSessionUser.getEmail());
	loginSession.setAttribute("pass", loSessionUser.getPassWord());
	request.getRequestDispatcher("dsb.jsp").forward(request,response);
	//out1.print(loginSession.getAttribute("user"));
	
	}else{
		 out1.println("<html>");
		    out1.println("<head>");
		    out1.println("<title>Invalid Request</title>");
		    out1.println("</head>");
		    out1.println("<body bgcolor=\"white\"> <b> Invalid Url Accessed<br>Please  <a href='login.jsp'>Login Again</a>");
		    out1.println("</body>");
		    out1.println("</html>");
		
	}
		}catch (ServletException E){
			
		}
		
	}

}
