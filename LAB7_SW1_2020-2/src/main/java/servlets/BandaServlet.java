package servlets;

import Beans.Banda;
import Daos.BandaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BandaServlet",urlPatterns = {"/listaBandas"})
public class BandaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filter = request.getParameter("filter");
        if(filter==null) filter="";

        BandaDao bandaDao = new BandaDao();
        ArrayList<Banda> listaBandas = bandaDao.obtenerListaBandas(filter);

        request.setAttribute("listaBandas",listaBandas);

        RequestDispatcher view =request.getRequestDispatcher("listaBandas.jsp");
        view.forward(request,response);
    }
}
