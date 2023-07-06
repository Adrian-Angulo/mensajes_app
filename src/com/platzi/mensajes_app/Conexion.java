/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author ADRIAN CASTILLO
 */
public class Conexion {
    public Connection get_Connection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(con != null){
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
