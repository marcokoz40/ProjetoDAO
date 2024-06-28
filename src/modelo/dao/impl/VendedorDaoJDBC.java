package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	
	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT vendedor .*, departamento.Nome as NomeDep "
					                  + "FROM vendedor  INNER JOIN departamento "
					                  + "ON vendedor.IdDepartamento = departamento.Id "
					                  + "WHERE vendedor.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 if (rs.next()) {
				 Departamento dep = new Departamento();
				 dep.setId(rs.getInt("IdDepartamento"));
				 dep.setNome(rs.getString("NomeDep"));
				 Vendedor vend = new Vendedor();
				 vend.setId(rs.getInt("Id"));
				 vend.setNome(rs.getString("Nome"));
				 vend.setEmail(rs.getString("Email"));
				 vend.setDataNasc(rs.getDate("DataNascimento"));
				 vend.setSalario(rs.getDouble("Salario"));
				 vend.setDepartamento(dep);
				 return vend;
				 				 
			 }
			 return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
