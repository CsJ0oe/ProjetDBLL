package tn.dbll.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.dbll.beans.Job;
import tn.dbll.beans.JsonStatus;

public class JobCreate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String img = request.getParameter("img");
        String time = request.getParameter("time");
        String price = request.getParameter("price");
        if (name != null && !name.isEmpty() && location != null && !location.isEmpty()) {
            Job job = new Job();
            if (job.create(name, location, img, time, price)) {
                response.getWriter().write(JsonStatus.success(job.toString()));
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
