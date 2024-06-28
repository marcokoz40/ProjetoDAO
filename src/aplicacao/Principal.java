package aplicacao;

import java.util.Locale;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
				
		VendedorDao vendedorDao = FabricaDao.criaVendedorDao();
		Vendedor vend = vendedorDao.findById(2);
		System.out.println(vend);

	}

}
