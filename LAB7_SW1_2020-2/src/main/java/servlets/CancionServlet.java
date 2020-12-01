package servlets;

import Beans.Artista;
import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionServlet", urlPatterns = {"/listaCanciones"})
public class CancionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancionDao = new CancionDao();

        String order = request.getParameter("order");
        ArrayList<Cancion> canciones;
        if (order == null) order = "";
        if (order.equals("on")) {
            canciones = cancionDao.obtenerListaCancionesOrdenadas();
            request.setAttribute("ordenada", true);
        } else {
            canciones = cancionDao.obtenerListaCanciones();
            request.setAttribute("ordenada", false);
        }

        request.setAttribute("listaCanciones", canciones);

        RequestDispatcher view = request.getRequestDispatcher("listaCanciones.jsp");
        view.forward(request, response);
    }
}
