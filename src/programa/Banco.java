package programa;

import java.util.ArrayList;
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Banco {

	//static Scanner scan = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("                     Java Bank" + "\n" +
				 "\n   --- Selecione uma operação ---" + 
				 "\n             [ 1 ] - Criar Conta" +
				 "\n             [ 2 ] - Depósito" +
				 "\n             [ 3 ] - Saque" +
				 "\n             [ 4 ] - Transferência" +
				 "\n             [ 0 ] - Pix" +
				 "\n             [ 5 ] - Cancelar Conta" +
				 "\n             [ 6 ] - Listagem" +
				 "\n             [ 7 ] - Sair"));	
			
		/*
		 * System.out.println("------------------------------------------");
		 * System.out.println("---------Bem vindos ao nosso Banco--------");
		 * System.out.println("------------------------------------------");
		 * System.out.println("-------** Selecione uma operação **-------");
		 * System.out.println("------------------------------------------");
		 * System.out.println("|    Opção 1 - Criar Conta    ");
		 * System.out.println("|    Opção 2 - Depósito       ");
		 * System.out.println("|    Opção 3 - Saque          ");
		 * System.out.println("|    Opção 4 - Transferência  "); 
		 * System.out.println("|    Opção 5 - Pix            ");
		 * System.out.println("|    Opção 5 - Listagem       ");
		 * System.out.println("|    Opção 6 - Sair           ");
		 */

		//int operacao = scan.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			/*
			 * case 5: pix(); break;
			 */
		case 5: 
			cancelarConta(); 
		    break;
		case 6:
			listarContas();
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossos serviços, até breve!");
			//System.out.println("Obrigado por usar nossos serviços, até breve!");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			//System.out.println("Opção Inválida!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {
		
		Cliente cliente = new Cliente();

		cliente.setNome(JOptionPane.showInputDialog("Nome: "));
		//System.out.println("\nNome: ");
		//String nome = scan.next();

		cliente.setTelefone(JOptionPane.showInputDialog("Telefone: "));
		//System.out.println("\nTelefone: ");
		//String telefone = scan.next();

		cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
		//System.out.println("\nCPF: ");
		//String cpf = scan.next();

		cliente.setDataNascimento(JOptionPane.showInputDialog("Data de Nascimento: "));
		//System.out.println("\nData de Nascimento: ");
		//String dataNascimento = scan.next();

		cliente.setEmail(JOptionPane.showInputDialog("Email: "));
		//System.out.println("\nEmail: ");
		//String email = scan.next();

		//Cliente cliente = new Cliente(nome, telefone, cpf, dataNascimento, email);

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);

		JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
		//System.out.println("Conta criada com sucesso!");
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {

		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
		//System.out.println("Digite o número da conta: ");
		//int numeroConta = scan.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito: "));
			//System.out.println("Digite o valor do depósito: ");
			//Double valorDeposito = scan.nextDouble();
			conta.deposito(valorDeposito);
		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
			//System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
		//System.out.println("Digite o número da conta: ");
		//int numeroConta = scan.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque: "));
			//System.out.println("Digite o valor do saque: ");
			//Double valorSaque = scan.nextDouble();
			conta.saque(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
			//System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void transferir() {
		int numeroContaOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua conta: "));
		//System.out.println("Digite o número da sua conta: ");
		//int numeroContaOrigem = scan.nextInt();
		Conta contaOrigem = encontrarConta(numeroContaOrigem);

		if (contaOrigem != null) {
			int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de destino: "));
			//System.out.println("Digite o número da conta de destino: ");
			//int numeroContaDestino = scan.nextInt();
			Conta contaDestino = encontrarConta(numeroContaDestino);

			if (contaDestino != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser transferido: "));
				//System.out.println("Digite o valor a ser transferido: ");
				//Double valor = scan.nextDouble();
				contaOrigem.transferencia(contaDestino, valor);
			} else {
				JOptionPane.showMessageDialog(null, "Conta não encontrada!");
				//System.out.println("Conta não encontrada!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
			//System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
				//System.out.println(conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não existem contas cadastradas!");
			//System.out.println("Não existem contas cadastradas");
		}
		operacoes();
	}

	 public static void cancelarConta() {
	 
		 int numeroContaCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua conta: "));
			
			Conta numeroConta = encontrarConta(numeroContaCliente);
	    //System.out.println("\nDigite o numero da sua conta: "); 
	    //String numeroDaConta = scan.next(); 
	 
		 if(numeroConta != null && numeroConta.getSaldo() == 0) {	 
			 contasBancarias.remove(numeroConta); 
			 JOptionPane.showMessageDialog(null, "Conta cancelada com sucesso!");
			//System.out.println("Conta cancelada com sucesso!");
	     } else if(numeroConta == null) {
	    	 JOptionPane.showMessageDialog(null, "Conta não encontrada!"); 
	     }
		 else {
			 JOptionPane.showMessageDialog(null, "Existem valores na conta a serem retirados!");
			 //System.out.println("Existem valores na conta a serem retirados!");
	     }
		 operacoes();
    }
	 

}
