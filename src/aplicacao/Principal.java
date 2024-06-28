package aplicacao;

import java.util.List;
import java.util.Locale;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
				
		VendedorDao vendedorDao = FabricaDao.criaVendedorDao();
		System.out.println("===== Teste 1 =====");
		Vendedor vend = vendedorDao.findById(2);
		System.out.println(vend);
		System.out.println("\n ===== Teste 2 =====");
        Departamento dep = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.findByDepartament(dep);
		lista.forEach(System.out::println);
		System.out.println("\n ===== Teste 3 =====");
       	lista = vendedorDao.findAll();
		lista.forEach(System.out::println);
	}

}
