package modelo;

import excecoes.SaldoInsuficienteException;
import interfac.Transferivel;

public class ContaCorrente extends Conta implements Transferivel{
    
    private Conta conta;
    private double limiteChequeEsp;

    public ContaCorrente(Conta conta, double limiteChequeEsp, int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
        this.conta = conta;
        this.limiteChequeEsp = limiteChequeEsp;
    }

    public double getLimiteChequeEsp() {
        return limiteChequeEsp;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo + limiteChequeEsp) {
            throw new SaldoInsuficienteException("Limite excedido. Disponível: " + (saldo + limiteChequeEsp));
        }
        saldo -= valor;
    }
    @Override
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);
    }
    
}