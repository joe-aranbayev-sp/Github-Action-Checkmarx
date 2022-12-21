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

/**
 * First update for a BitBucket 'push' to 'origin/master' - 
 * 01/11/2022 
 */

/**
 * Second update for a BitBucket 'push' to 'origin/master' - 
 * 01/04/2023 
 */

/**
 * Third update for a BitBucket 'push' to 'origin/master' - 
 * 01/04/2021 
 */

/**
 * Fourth update for a BitBucket 'push' to 'origin/master' - 
 * 01/04/2021 
 */

/**
 * Fifth update for a BitBucket 'push' to 'origin/master' - 
 * 01/04/2021 
 */

/**
 * Sixth update for a BitBucket 'push' to 'origin/master' - 
 * 01/05/2021 
 */

/**
 * Seventh update for a BitBucket 'push' to 'origin/master' - 
 * 01/05/2021 
 */

/**
 * Eightth update for a BitBucket 'push' to 'origin/master'
 * - 01/05/2021 
 */

/**
 * Nineth update for a BitBucket 'push' to 'origin/master'
 * - 01/05/2021 
 */

/**
 * Tenth update for a BitBucket 'push' to 'origin/master'
 * - 01/05/2021 
 */

/**
 * Eleventh update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * Twelveth update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * Thirteenth update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * Fourteenth update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * Fifteenth update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * Sixteenth update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * 17th update for a BitBucket 'push' to 'origin/master'
 * - 01/12/2021 
 */

/**
 * 18th update for a BitBucket 'push' to 'origin/master'
 * - 06/02/2021 
 */

/**
 * 19th update for a BitBucket 'push' to 'origin/master'
 * - 06/02/2021 
 */

/**
 * 20th update for a BitBucket 'push' to 'origin/master'
 * - 06/02/2021 
 */

/**
 * 21st update for a BitBucket 'push' to 'origin/master'
 * - 06/02/2021 
 */

/**
 * 22nd update for a BitBucket 'push' to 'origin/master'
 * - 06/03/2021 
 */

/**
 * 23rd update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 24th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 25th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 26th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 27th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 28th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 29th update for a GitHub2 'push' to 'origin/master'
 * - 06/22/2021 
 */

/**
 * 30th update for a GitHub3 'push' to 'origin/master'
 * - 06/25/2021 
 */

/**
 * Servlet implementation class SQLInjectionSampleServlet.
 */
//new comment
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
