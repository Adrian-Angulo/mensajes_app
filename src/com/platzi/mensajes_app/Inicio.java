/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author ADRIAN CASTILLO
 */
public class Inicio {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {            
            System.out.println("--------------------");
            System.out.println(" Aplicacion de Mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensaje");
            System.out.println(" 3. editar mensaje");
            System.out.println(" 4. eliminar mensaje");
            System.out.println(" 5. Salir");
            System.out.print("Digite una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                case 5:
                    System.out.println("Has salido de la aplicacion");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion !=5);
        
//        Conexion conexion = new Conexion();
//        try (Connection cnx = conexion.get_Connection()){
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
