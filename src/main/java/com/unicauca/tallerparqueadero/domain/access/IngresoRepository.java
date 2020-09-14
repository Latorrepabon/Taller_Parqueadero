package com.unicauca.tallerparqueadero.domain.access;

import com.unicauca.tallerparqueadero.domain.Ingreso;
import com.unicauca.tallerparqueadero.domain.AutoEnum;
import com.unicauca.tallerparqueadero.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Libardo, Julio, Alejandro
 */
public class IngresoRepository implements IIngresoRepository {

    private Connection conn;

    public IngresoRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Ingreso newIngreso) {

        try {
            //Validate product
            if (newIngreso == null || newIngreso.getIngresoId() < 0
                    || newIngreso.getTipoVehiculo().toString().isBlank() || newIngreso.getTiempo() <= 0 || newIngreso.getTarifa() < 0) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Ingreso (IngresoId, Tipo, Tiempo, Tarifa) "
                    + "VALUES ( ?, ?, ?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newIngreso.getIngresoId());
            pstmt.setString(2, newIngreso.getTipoVehiculo().toString());
            pstmt.setInt(3, newIngreso.getTiempo());
            pstmt.setInt(4, newIngreso.getTarifa());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Ingreso> list() {
        List<Ingreso> products = new ArrayList<>();
        try {

            String sql = "SELECT IngresoId, Tipo, Tarifa, Tiempo FROM Ingreso";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Ingreso newIngreso = new Ingreso();
                newIngreso.setIngresoId(rs.getInt("IngresoId"));
                String upperString = rs.getString("Tipo").toUpperCase();
                AutoEnum autoEnum = AutoEnum.valueOf(upperString);
                newIngreso.setTipoVehiculo(autoEnum);
                newIngreso.setTiempo(rs.getInt("Tiempo"));
                newIngreso.setTarifa(rs.getInt("Tarifa"));

                products.add(newIngreso);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Ingreso (\n"
                + "	IngresoId integer PRIMARY KEY,\n"
                + "	Tipo text NOT NULL,\n"
                + "	Tiempo integer,\n"
                + "	Tarifa integer"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
