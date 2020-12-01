package Daos;

import Beans.Artista;

import java.sql.*;
import java.util.ArrayList;

public class ArtistaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Artista> obtenerListaArtistas() {
        return query("select * from artista");
    }

    public ArrayList<Artista> obtenerListaArtistasFiltrados() {
        return query("select *,count(c.idcancion) as 'numcanciones' from artista a\n" +
                "     inner join banda bl on a.idartista=bL.artista_lider\n" +
                "     inner join cancion c on bl.idbanda = c.banda\n" +
                "group by bl.idbanda\n" +
                "having numcanciones > 5");
    }

    public ArrayList<Artista> query(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Artista> listaArtistas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String instrumento = rs.getString(3);
                String banda = rs.getString(4);
                listaArtistas.add(new Artista(id, nombre, instrumento, banda));
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaArtistas;
    }
}
