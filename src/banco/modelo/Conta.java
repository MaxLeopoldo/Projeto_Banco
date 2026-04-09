package modelo;

import excecoes.SaldoInsuficienteException;

public class Conta {
    protected int numeroConta;
    protected String titular;
    protected double saldo;

    public Conta(int numeroConta, String titular, double saldo) {
        super();
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double depositar(double valor){
        saldo = saldo +valor;
        return saldo;
    }
    public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor > saldo) {
        throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + saldo);
    }
    saldo -= valor;
    }
}