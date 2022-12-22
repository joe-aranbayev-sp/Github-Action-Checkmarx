package com.checkmarx.sample;

import  java.io.IOException;
import  java.io.PrintWriter;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.ResultSet;
import  java.sql.Statement;

import  javax.servlet.ServletException;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;


public class SQLInjectionSampleServlet extends HttpServlet
{

    /**
     * @see HttpServlet#HttpServlet()
     */

    public SQLInjectionSampleServlet()
    {

        super();

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>  methods.
     *
     * @param request             Servlet request
     * @param response            Servlet response
     * @throws ServletException   if a servlet-specific error occurs
     * @throws IOException        if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<h1>SQL Injection Example</h1><br/><br/>");

        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userCheck</title>");
            out.println("</head>");
            out.println("<body>");

            String user = request.getParameter("user");

            System.out.println("MySQL Connect Example.");

            Connection conn     = null;
            String     url      = "jdbc:mysql://127.0.0.1:3306/";
            String     dbName   = "sql_inject";
            String     driver   = "com.mysql.jdbc.Driver";
            String     userName = "root";
            String     password = "root";

            try 
            {

                Class.forName(driver).newInstance();

                conn = DriverManager.getConnection(url + dbName, userName, password);

                System.out.println("Connected to the database");

                String query = "SELECT * FROM User where userid='"+user+"'";

                out.println("Query : " + query);
                System.out.printf(query);

                Statement st  = conn.createStatement();
                ResultSet res = st.executeQuery(query);

                out.println("<br/><br/>Results");

                while (res.next())
                {

                    String s = res.getString("userId");

                    out.println("<br/><br/>\t\t"+s);

                }

                conn.close();

                System.out.println("Disconnected from database");

            } 
            catch (Exception e) 
            {

                e.printStackTrace();

            }

            out.println("</body>");
            out.println("</html>");

        } 
        finally 
        {

            out.close();

        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        processRequest(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        processRequest(request, response);

    }

}
