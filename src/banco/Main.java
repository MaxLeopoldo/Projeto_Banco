
import java.util.Scanner;

import excecoes.SaldoInsuficienteException;
import modelo.Conta;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;
import servicos.Banco;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcao;
        do { 
            exibirMenu();
            opcao = sc.nextInt();
                System.out.println("Numero da conta: ");
                int numeroConta = sc.nextInt();
                System.out.println("Nome do titular: ");
                String titular = sc.nextLine();
                sc.nextLine();
                System.out.println("Valor do saldo: ");
                double saldo = sc.nextDouble();
                Conta conta = new Conta(numeroConta, titular, saldo);
            if(opcao == 0){
                System.out.println("Limite do cheque especial: ");
                double limiteChequeEsp = sc.nextDouble();

                ContaCorrente contaCorrente = new ContaCorrente(conta, limiteChequeEsp);
                Banco.adicionarConta(contaCorrente);
                System.out.println("Deseja realizar uma transferencia? (s/n) ");
                String escolha = sc.nextLine();
                if(escolha.equals("s") ){
                System.out.println("Qual o número da conta destino? ");
                int numeroDestino = sc.nextInt();

                Conta destino = Banco.buscarPorNumero(numeroDestino);

                if (destino == null) {
                    System.out.println("Conta não encontrada!");
                } else {
                    double valorTransferencia = sc.nextDouble();
                    try {
                        contaCorrente.transferir(destino, valorTransferencia);
                        System.out.println("Transferência realizada com sucesso!");
                        System.out.println("Seu saldo atual: " + contaCorrente.getSaldo());
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                }

            }
            else if ( opcao == 1){
                System.out.println("Taxa de rendimento: ");
                double taxaRendimento = sc.nextDouble();

                ContaPoupanca contaPoupanca = new ContaPoupanca(conta , taxaRendimento);
                Banco.adicionarConta(contaPoupança);
                System.out.println("Deseja realizar uma transferencia? (s/n) ");
                String escolha = sc.nextLine();
                if(escolha.equals("s") ){
                System.out.println("Qual o número da conta destino? ");
                int numeroDestino = sc.nextInt();

                Conta destino = Banco.buscarPorNumero(numeroDestino);

                if (destino == null) {
                    System.out.println("Conta não encontrada!");
                } else {
                    double valorTransferencia = sc.nextDouble();
                    try {
                        contaPoupanca.transferir(destino, valorTransferencia);
                        System.out.println("Transferência realizada com sucesso!");
                        System.out.println("Seu saldo atual: " + contaPoupanca.getSaldo());
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                }
            }
            else if ( opcao == 2 ){
                System.out.println("Lista de contas: ");
                Banco.listarContas();
            }

        } while (opcao !=3);
        
        sc.close();
    }
    private static void exibirMenu(){
        System.out.println("Menu de contas ");
        System.out.println("0.Conta Corrente");
        System.out.println("1.Conta Poupança");
        System.out.println("2.Listar contas:");
        System.out.println("3.Sair");

    }
}
