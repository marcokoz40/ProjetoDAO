package modelo.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Vendedor {

	private Integer id;
	private String nome;
	private String email;
	private LocalDate dataNasc;
	private Double salario;
	private Departamento departamento;

	public Vendedor(Integer id, String nome, String email, LocalDate dataNasc, Double salario,
			Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNasc = dataNasc;
		this.salario = salario;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNasc, departamento, email, id, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(dataNasc, other.dataNasc) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNasc=" + dataNasc + ", salario="
				+ salario + ", departamento=" + departamento + "]";
	}

}
