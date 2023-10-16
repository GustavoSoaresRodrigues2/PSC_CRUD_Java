package br.com.bossini._usjt_psc_segunda_crud_pessoas;


import javax.swing.JOptionPane;
public class Principal {
    public static void main(String[] args) throws Exception{
        //1- Cadastrar uma pessoa
        //2- Listar os dados de todas as pessoas
        //3- Atualizar os dados de uma pessoa
        //4- Remover uma pessoa
        //0- Sair
        String menu = "1-Cadastrar\n2-Listar\n3-Atualizar\n4-Remover\n0-Sair";
        int op;
        do{
            op = Integer.parseInt(
                JOptionPane.showInputDialog(menu)
            );
            switch(op){
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome");
                    String fone = JOptionPane.showInputDialog("Digite o fone");
                    String email = JOptionPane.showInputDialog("Digite o email");
                    var pessoa = new Pessoa(nome, fone, email);
                    //mapeamento objeto relacional
                    //explicar como se dá a representação de um objeto pessoa no modelo relacional, ou seja,
                    //usando tabelas (JDBC)
                    var pessoaDAO = new PessoaDAO();
                    pessoaDAO.cadastrar(pessoa);
                    break;
            }
        }while(op != 0);
    }
}






