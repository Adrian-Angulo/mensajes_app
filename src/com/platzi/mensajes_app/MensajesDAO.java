/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADRIAN CASTILLO
 */
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_Connection()){
            PreparedStatement ps=null;
            try {
                String query = "INSERT INTO `mensajes` (mensaje,autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerMensajeDB() throws SQLException{
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;
        try (Connection conexion = db_connect.get_Connection()){
            
            String query = "SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            System.out.println("mensaje creado");
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("---------------------------------------");
            }
        
        }
    }
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_Connection()){
            PreparedStatement ps = null;
            try {
                String query ="DELETE FROM mensajes WHERE id_mensaje= ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensae ha sido borrado");
            } catch (Exception e) {
                System.out.println("No se pudo borra el mensaje");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_Connection()){
            PreparedStatement ps=null;
            try{
               String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
               ps=conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
               ps.executeUpdate();
               System.out.println("mensaje se actualizo correctamente");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("no se puedo actulizar el mensaje");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
