package servlets;

import Beans.Banda;
import Beans.TPC;
import Daos.BandaDao;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ToursPorCiudadServlet",urlPatterns = {"/listaToursporCiudad"})
public class ToursPorCiudadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourDao tourDao = new TourDao();
        ArrayList<TPC> listaToursporCiudad = tourDao.obtenerListaToursporCiudad();

        request.setAttribute("listaToursporCiudad",listaToursporCiudad);

        RequestDispatcher view =request.getRequestDispatcher("listaToursporCiudad.jsp");
        view.forward(request,response);
    }
}
