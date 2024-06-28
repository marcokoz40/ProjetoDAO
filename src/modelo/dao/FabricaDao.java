package modelo.dao;

import modelo.dao.impl.VendedorDaoJDBC;

public class FabricaDao {
	
	public static VendedorDao criaVendedorDao() {
		return new VendedorDaoJDBC();
	}

}
