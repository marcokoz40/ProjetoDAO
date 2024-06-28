package aplicacao;

import java.time.LocalDate;
import java.util.Locale;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Departamento dep = new Departamento(1, "Eletrônicos");
		Vendedor vend = new Vendedor(1, "José", "jose@gmail.com", LocalDate.parse("1977-12-24"), 3000.0, dep);
		System.out.println(vend);

	}

}
