package programa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	
	private static int contador = 1;
	
	private String nome;
	private String telefone;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String telefone, String cpf, String dataNascimento, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		contador += 1;	
	}
	
	public String toString() {
		   return "\nNome: " + this.getNome() +
		          "\nTelefone: " + this.getTelefone() +
		          "\nCPF: " + this.getCpf() +
		          "\nData de Nascimento: " + this.getDataNascimento() +
		          "\nEmail: " + this.getEmail();      
		}
	
}
