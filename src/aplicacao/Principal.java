package aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
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
		System.out.println("\n ===== Teste 4 =====");
		Vendedor vend1 = new Vendedor(null, "Marco", "marco@gmail.com", new Date(), 5000.00, dep);
		vendedorDao.insert(vend1);
		System.out.println("Id = " + vend1.getId());
		System.out.println("\n ===== Teste 5 =====");
		vend = vendedorDao.findById(1);
		vend.setNome("Mariazinha");
		vendedorDao.update(vend);
		System.out.println("TABELA ATUALIZADA");
		System.out.println("\n ===== Teste 6 =====");
		System.out.print("Informe o id a ser excluido: ");
		int id = sc.nextInt();
		vendedorDao.deleteById(id);
		System.out.println("ID EXCLUIDO");
		sc.close();
	}

}
