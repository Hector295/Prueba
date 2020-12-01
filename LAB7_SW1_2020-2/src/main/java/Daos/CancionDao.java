package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Cancion> obtenerListaCanciones() {
        return query("select * from cancion ");
    }

    public ArrayList<Cancion> obtenerListaCancionesOrdenadas() {
        return query("select * from cancion order by nombre_cancion ASC");
    }

    public ArrayList<Cancion> query(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idCancion = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);
                listaCanciones.add(new Cancion(idCancion, nombre, banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }

}
