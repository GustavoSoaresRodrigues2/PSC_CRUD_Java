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
    
}
