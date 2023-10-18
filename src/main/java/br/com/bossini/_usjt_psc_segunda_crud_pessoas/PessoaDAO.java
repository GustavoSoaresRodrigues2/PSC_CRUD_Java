package br.com.bossini._usjt_psc_segunda_crud_pessoas;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PessoaDAO {
    
    public void cadastrar(Pessoa p) throws Exception {
       
        String sql = 
                "INSERT INTO tb_pessoa"
                    + "(nome, fone, email, ativo) "
                + "VALUES "
                    + "(?, ?, ?, 1)";
        
        try(
            var conexao = ConnectionFactory.conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, p.getNome());
            ps.setString(2, p.getFone());
            ps.setString(3, p.getEmail());
            
            ps.execute();
            
        } catch (Exception e) {}
    }
    
    public void atualizar(Pessoa p) throws Exception{
        
        String sql = 
            "UPDATE tb_pessoa "
                + "SET nome = ?, fone = ?, email = ? "
                    + "WHERE cod_pessoa = ?;";
        
        try(
            var conexao = ConnectionFactory.conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, p.getNome());
            ps.setString(2, p.getFone());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getCodigo());
            
            ps.execute();
            
        } catch (Exception e) {}
    }
    
    public void deletar(Pessoa p) throws Exception {
        
        String sql = 
                "DELETE FROM tb_pessoa "
                    + "WHERE cod_pessoa = ?";
        
        try(
            var conexao = new ConnectionFactory().conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, p.getCodigo());
            
            ps.execute();
            
        } catch (Exception e) {}
        
    }
    
    public void desativar(Pessoa p) throws Exception {
        
        String sql = "UPDATE tb_pessoa SET ativo = 0 WHERE cod_pessoa = ?";
        
        try(
            var conexao = ConnectionFactory.conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, p.getCodigo());
            
            ps.execute();
            
        } catch (Exception e) {}
        
    }
    
    public void listar() throws Exception {
        
        String sql = "SELECT * FROM tb_pessoa";
        
        try(
            var conexao = ConnectionFactory.conectar();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()) {
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
            
                System.out.printf(
                    "Nome: %s, Fone: %s, Email: %s\n",
                    nome, fone, email
                );
            }            
        } catch (Exception e) {}
    }
}
