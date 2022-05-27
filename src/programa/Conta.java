package programa;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
import utilitarios.Util;

@Getter
@Setter
public class Conta {
	
	private static int contadorDeContas = 1;
	
	
	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	public Conta (Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		contadorDeContas += 1;
	}
	
	 public String toString() {
	    return "\nNúmero da conta: " + this.getNumeroConta() +
	           "\nNome: " + this.cliente.getNome() +
		       "\nTelefone: " + this.cliente.getTelefone() +
		       "\nCPF: " + this.cliente.getCpf() +
		       "\nData de Nascimento: " + this.cliente.getDataNascimento() +
		       "\nEmail: " + this.cliente.getEmail() +
		       "\nSaldo: " + Util.doubleToString(this.getSaldo()) +
		       "\n";
	 }
	 
	 public void deposito(Double valor) {
		 if(valor > 0) {
			 setSaldo(getSaldo() + valor);
			 JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
			 //System.out.println("Depósito realizado com sucesso!");
		 }else {
			 JOptionPane.showMessageDialog(null, "Valor inválido!");
			 //System.out.println("Valor inválido!");
		 }
	 }
	 
	 public void saque(Double valor) {
		 if(valor > 0 && this.getSaldo() >= valor) {
			 setSaldo(getSaldo() - valor);
			 JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
			 //System.out.println("Saque realizado com sucesso!");
		 }else {
			 JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
			 //System.out.println("Saldo insuficiente!");
		 }
	 }
	 
	 public void transferencia(Conta contaParaDeposito, Double valor) {
		 if(valor > 0 && this.getSaldo() >= valor) {
			 setSaldo(getSaldo() - valor);
			 
			 contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			 JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
			 //System.out.println("Transferência realizada com sucesso!");
		 }else {
			 JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
			 //System.out.println("Não foi possível realizar a transferência!");
		 }
	 }
	 	 
}
