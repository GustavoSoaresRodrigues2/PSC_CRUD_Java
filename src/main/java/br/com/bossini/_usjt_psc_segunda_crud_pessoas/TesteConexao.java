package br.com.bossini._usjt_psc_segunda_crud_pessoas;

import javax.swing.JOptionPane;

public class TesteConexao {
    public static void main(String[] args){
        try{
            var factory = new ConnectionFactory();
            var minhaConexao = factory.conectar();
            System.out.println("Conectou!!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage()
            );
            e.printStackTrace();
        }
    }
}
