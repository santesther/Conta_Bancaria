import domain.ContaBancaria;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do depósito inicial: ");
        float depositoInicial = scanner.nextFloat();

        ContaBancaria conta = new ContaBancaria(depositoInicial);

        int opcao = 0;

        do {
            System.out.println("==========Sistema Bancário==========");
            System.out.println();
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Pagar boleto");
            System.out.println("4 - Consultar saldo");
            System.out.println("5 - Consultar cheque especial");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("7 - Sair");
            System.out.println("Escolhe uma opção do menu: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Informe o valor do deposito");
                    float valor = scanner.nextFloat();
                    conta.depositar(valor);
                    break;
                case 2:
                    System.out.println("Informe o valor de saque: ");
                    float valorDeSaque = scanner.nextFloat();
                    conta.sacar(valorDeSaque);
                    break;
                case 3:
                    System.out.println("Informe o valor do boleto");
                    float valorBoleto = scanner.nextFloat();
                    conta.pagarBoleto(valorBoleto);
                    break;
                case 4:
                    System.out.println("O saldo é de: " + conta.getSaldo());
                    break;
                case 5:
                    System.out.println("O valor do cheque especial é de: " + conta.getLimiteCheque());
                    break;
                case 6:
                    System.out.println("O cheque especial está em uso (true/false): " + conta.checkChequeEspecial());
                    break;
                case 7:
                    System.out.println("Saindo do programa");
            }
        } while (opcao != 7);

        scanner.close();
    }
}