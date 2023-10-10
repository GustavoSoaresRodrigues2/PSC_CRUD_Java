/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bossini._usjt_psc_segunda_crud_pessoas;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    private final String host = "localhost";
    private final String port = "3306";
    private final String user = "root";
    //maquinas da USJT: senha anima123
    private final String password = "1234567";
    private final String db = "20232_usjt_psc_segunda_pessoas";
    
    public Connection conectar() throws Exception {
        //http://dontpad.com:80/bossini
        //String de conexão
        //String s = "jdbc:mysql://" + host + ":" + port + "/" + db;
        String s = String.format(
            "jdbc:mysql://%s:%s/%s",
            host, port, db
        );
        
        Connection c = DriverManager.getConnection(
                s, 
                user, 
                password
        );
        return c;
    }
    
}
