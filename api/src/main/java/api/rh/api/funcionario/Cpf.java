package api.rh.api.funcionario;

public class Cpf {

	private String cpf;
	
	public Cpf(String cpf) {
        this.cpf = cpf;
    }
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return getCpf();
	}
}
