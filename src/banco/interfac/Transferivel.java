package interfac;

import excecoes.SaldoInsuficienteException;
import modelo.Conta;

public interface Transferivel {
    void transferir(Conta destino , double valor) throws SaldoInsuficienteException;
}
