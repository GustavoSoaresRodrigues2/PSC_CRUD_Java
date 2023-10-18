package br.com.bossini._usjt_psc_segunda_crud_pessoas;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    private static final String host = "mysql-14dac390-bd-aiven.aivencloud.com";
    private static final String port = "23087";
    private static final String user = "avnadmin";
    //maquinas da USJT: senha anima123
    private static final String password = "AVNS_edwYCWnPOR5G5swQxr0";
    private static final String db = "defaultdb";
    
    public static Connection conectar() throws Exception {
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
