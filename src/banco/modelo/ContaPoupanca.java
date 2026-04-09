package modelo;

import excecoes.SaldoInsuficienteException;

public class ContaPoupanca extends Conta{
    private Conta conta;
    private double taxaRendimento;

    public ContaPoupanca(Conta conta ,double taxaRendimento, int numeroConta, String titular, double saldo) {
        super(numeroConta,titular,saldo);
        this.conta=conta;  
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
    @Override
    public double depositar(double valor){
        saldo = saldo + valor;
        return saldo;
    }
    @Override
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
    this.sacar(valor);
    destino.depositar(valor);
}
}
