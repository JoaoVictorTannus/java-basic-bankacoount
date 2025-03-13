import java.util.Scanner;  // Importa a classe Scanner para ler entradas do usuário


/**
 * A classe ContaTerminal simula a criação de uma conta bancária.
 * Ela permite ao usuário inserir dados como nome, número da agência,
 * número da conta, tipo de conta e saldo, e depois exibe essas informações
 * com uma saudação personalizada com base no horário do dia.
 * 
 * <p>Este programa valida as entradas do número da conta e saldo, 
 * garantindo que sejam números válidos e que o saldo seja não negativo.</p>
 */
public class ContaTerminal {

    /**
     * Método principal que executa o programa de criação da conta bancária.
     * 
     * @param args Argumentos da linha de comando, não utilizados neste programa.
     */
    public static void main(String[] args) {

        // Criação do objeto Scanner para ler entradas do terminal
        Scanner scanner = new Scanner(System.in);

        // Declaração das variáveis que serão usadas para armazenar as entradas do usuário
        int numero;           // Número da conta bancária
        String agencia;       // Número da agência bancária
        String nomeCliente;   // Nome do cliente
        double saldo;         // Saldo da conta bancária
        String tipoConta;     // Tipo da conta (Conta Corrente, Conta Poupança, etc.)

        // Solicita e lê o nome do cliente
        System.out.print("Por favor, digite o Nome do Cliente: ");
        nomeCliente = scanner.nextLine();  // Lê a entrada do terminal para o nome do cliente

        // Solicita e lê o número da agência
        System.out.print("Por favor, digite o número da Agência: ");
        agencia = scanner.nextLine();  // Lê a entrada do terminal para o número da agência (texto)

        // Solicita e lê o número da conta, com validação de entrada
        while (true) {
            System.out.print("Por favor, digite o número da Conta: ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();   // Lê o número da conta (inteiro)
                break; // Se a entrada for válida, sai do loop
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a conta.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        // Limpa o buffer do scanner após a leitura de um número
        scanner.nextLine();

        // Solicita o tipo de conta
        System.out.print("Por favor, digite o tipo de conta (ex: Conta Corrente, Conta Poupança): ");
        tipoConta = scanner.nextLine();  // Lê o tipo da conta

        // Solicita e lê o saldo da conta, com validação de entrada
        while (true) {
            System.out.print("Por favor, digite o saldo da conta: ");
            if (scanner.hasNextDouble()) {
                saldo = scanner.nextDouble();  // Lê o saldo da conta (decimal)
                if (saldo >= 0) {
                    break; // Se o saldo for positivo, sai do loop
                } else {
                    System.out.println("Saldo inválido. O saldo não pode ser negativo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número decimal para o saldo.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        // Formata o saldo para exibição com duas casas decimais
        String saldoFormatado = String.format("%.2f", saldo);

        // Saudação personalizada com base no horário
        String saudacao = "";
        int hora = java.time.LocalTime.now().getHour();  // Obtém a hora atual
        if (hora >= 6 && hora < 12) {
            saudacao = "Bom dia"; // Saudação para manhã
        } else if (hora >= 12 && hora < 18) {
            saudacao = "Boa tarde"; // Saudação para tarde
        } else {
            saudacao = "Boa noite"; // Saudação para noite
        }

        // Exibe a mensagem final com os dados inseridos
        System.out.println("\n" + saudacao + " " + nomeCliente + ",\nObrigado por criar uma conta em nosso banco. Estes são os seus dados atuais: ");
        System.out.println("Tipo de Conta: " + tipoConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.println("Saldo: R$ " + saldoFormatado);
        System.out.println("Já está disponível para ser utilizada.");

        // Fecha o scanner para liberar os recursos
        scanner.close();
    }
}
