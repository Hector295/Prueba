package Daos;

import Beans.Banda;

import java.sql.*;
import java.util.ArrayList;

public class BandaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Banda> obtenerListaBandas(String filter) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Banda> listaBandas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement("select * from banda b inner join artista a on a.idartista=b.artista_lider where a.nombre_artista like ? or b.nombre_banda like ?");) {
            pstmt.setString(1, "%"+filter);
            pstmt.setString(2, "%"+filter);
            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String idBanda = rs.getString(1);
                    String nombre = rs.getString(2);
                    int lider = rs.getInt(3);

                    listaBandas.add(new Banda(idBanda, nombre, lider));
                }
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaBandas;

    }


}
