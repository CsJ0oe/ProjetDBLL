package tn.dbll.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.dbll.beans.Job;
import tn.dbll.beans.JsonStatus;

public class JobUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        if (id != null && !id.isEmpty() && id.matches("[0-9]+")) {
            Job job = new Job();
            if (job.read(Integer.parseInt(id))) {
                if (job.update(name, location)) {
                    response.getWriter().write(JsonStatus.success(job.toString()));
                } else {
                    response.getWriter().write(JsonStatus.error("SQL ERROR"));
                }
            } else {
                response.getWriter().write(JsonStatus.error("SQL ERROR"));
            }
        } else {
            response.getWriter().write(JsonStatus.failed("Invalid Parameters"));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // </editor-fold>

}
