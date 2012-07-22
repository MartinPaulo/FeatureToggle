package au.edu.versi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Our own front controller that acts as a Major Domo to those arriving at our site...
 */
public class MajorDomoServlet extends HttpServlet {

    protected static final String DELUX_INDEX_JSP = "/featurefulIndex.jsp";
    protected static final String BASIC_INDEX_JSP = "/basicIndex.jsp";

    private static final long serialVersionUID = -6682449053889091301L;

    private boolean isBasic = FeatureSetFactory.getFeatureSet().isBasicApplication();
   

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(getHomePage());
        dispatcher.forward(request, response);
    }

    protected String getHomePage() {
        return isBasic ? BASIC_INDEX_JSP : DELUX_INDEX_JSP;
    }

}
