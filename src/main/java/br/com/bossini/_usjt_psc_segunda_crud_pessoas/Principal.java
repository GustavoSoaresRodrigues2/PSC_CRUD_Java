package br.com.bossini._usjt_psc_segunda_crud_pessoas;


import javax.swing.JOptionPane;
public class Principal {
    public static void main(String[] args) throws Exception{
        
        var pessoaDAO = new PessoaDAO();
                    
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
                    
                    pessoaDAO.cadastrar(pessoa);
                    break;
                    
                case 2:
                    pessoaDAO.listar();
                    break;
                    
            }
        }while(op != 0);
    }
}






