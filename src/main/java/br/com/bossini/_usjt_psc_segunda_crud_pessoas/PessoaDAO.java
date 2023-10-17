package br.com.bossini._usjt_psc_segunda_crud_pessoas;

import java.sql.PreparedStatement;

public class PessoaDAO {
    //DAO: Data Access Object
    //oferece funcionalidades de acesso aos dados (no banco de dados) de objetos do tipo pessoa
    public void cadastrar(Pessoa p) throws Exception {
        //1. Especificar o comando SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        //2. Abrir uma conexão com o MySQL
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        //3. Preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir os eventuais placeholders
        ps.setString(1, p.getNome());
        ps.setString(2, p.getFone());
        ps.setString(3, p.getEmail());
        //5. Executar o comando preparado
        ps.execute();
        //6. Fechar a conexão
        ps.close();
        conexao.close();
    }
    
    public void atualizar(Pessoa p) throws Exception{
        //1. Especificar o comando SQL
        String sql = 
        "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE cod_pessoa = ?;";
        //2. Abrir conexão com o banco
        //Java 7: try-with-resources
        //Java 10: var
        try(
            var conexao = ConnectionFactory.conectar();
            //3. Preparar o comando
            var ps = conexao.prepareStatement(sql);
        ){
            //4. Substituir os eventuais placeholders
            ps.setString(1, p.getNome());
            ps.setString(2, p.getFone());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getCodigo());
            //5. Executar o comando
            ps.execute();
            //6. Fechar as coisas
            //try-with-resources já fez :)
        }
    }
    public void desativar(Pessoa p) throws Exception{
        //1. Especificar o comando SQL
        String sql = "UPDATE tb_pessoa SET ativo = 0 WHERE cod_pessoa = ?";
        //2. Abrir conexão
        try(
            var conexao = ConnectionFactory.conectar();
            //3. Preparar o comando
            var ps = conexao.prepareStatement(sql);
        ){
            //4. Substituir os eventuais placeholders
            ps.setInt(1, p.getCodigo());
            //5. Executar o comando
            ps.execute();
            //6. Fechar tudo
            //try-with-resources já fez :))
        }
        
    }
    public void deletar(Pessoa p) throws Exception{
        //1. Especificar o comando SQL
        String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
        //2. Abrir uma conexão com o MySQL
        try(
            var conexao = new ConnectionFactory().conectar();
            //3. Preparar o comando
            var ps = conexao.prepareStatement(sql);
        ){
            //4. Substituir os eventuais placeholders
            ps.setInt(1, p.getCodigo());
            //5. Executar o comando preparado
            ps.execute();
            //6. Fechar as coisas
            //já foi feito pelo try-with-resources =)
        }
        
    }
}
