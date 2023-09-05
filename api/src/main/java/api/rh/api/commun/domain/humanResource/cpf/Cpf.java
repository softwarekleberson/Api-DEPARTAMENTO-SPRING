package api.rh.api.commun.domain.humanResource.cpf;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cpf other = (Cpf) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
}
