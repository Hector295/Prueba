package servlets;

import Beans.Artista;
import Beans.Cancion;
import Daos.ArtistaDao;
import Daos.CancionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArtistaServlet", urlPatterns = {"/listaArtistas"})
public class ArtistaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArtistaDao artistaDao = new ArtistaDao();

        String filter = request.getParameter("filter");
        ArrayList<Artista> artistas;
        if (filter == null) filter = "";
        if (filter.equals("on")) {
            artistas = artistaDao.obtenerListaArtistasFiltrados();
            request.setAttribute("filtrada", true);
        } else {
            artistas = artistaDao.obtenerListaArtistas();
            request.setAttribute("filtrada", false);
        }

        request.setAttribute("listaArtistas", artistas);

        RequestDispatcher view = request.getRequestDispatcher("listaArtistas.jsp");
        view.forward(request, response);
    }
}
