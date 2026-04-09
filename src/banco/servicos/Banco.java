package servicos;

import java.util.List;
import modelo.Conta;

public class Banco {
    private List<Conta> conta;

    public Banco(List<Conta> conta) {
        this.conta = conta;
    }

    public void adicionarConta(Conta c){
        conta.add(c);
    }
    public Conta buscarPorNumero(int num){
        for(Conta c : conta){
            if ( c.getNumeroConta() == num){
                return c;
            }
        }
        return null;
    }
    public void listarContas(){
        for (Conta c : conta){
            System.out.println(c);
        }
    }
    
}
