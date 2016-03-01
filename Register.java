package Sri.com;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet  
{
@Override
public void init(javax.servlet.ServletConfig config) throws ServletException {
	System.out.println("Hai subbu");
}; 
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stubH
	//super.doPost(req, resp);
	System.out.println("Hai");
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String name=req.getParameter("Name");
	String pass=req.getParameter("pass");
	String email=req.getParameter("email");
	String country=req.getParameter("country");
	System.out.println(country);
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Drivers  laoded");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		System.out.println("Connnected");
		
		PreparedStatement pst=conn.prepareStatement("insert into userdtl values(?,?,?,?)");
		
		pst.setString(1, name);
		pst.setString(2, pass);
		pst.setString(3, email);
		pst.setString(4, country);
		
		int i=pst.executeUpdate();
		conn.close();
		
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
out.print("Sucessfully incorporated");
}
	
}
