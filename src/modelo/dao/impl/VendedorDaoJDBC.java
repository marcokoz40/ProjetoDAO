package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				 Departamento dep = instanciaDep(rs);
				 Vendedor vend = instanciaVend(rs, dep);
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

	private Vendedor instanciaVend(ResultSet rs, Departamento dep) throws SQLException {
		 Vendedor vend = new Vendedor();
		 vend.setId(rs.getInt("Id"));
		 vend.setNome(rs.getString("Nome"));
		 vend.setEmail(rs.getString("Email"));
		 vend.setDataNasc(rs.getDate("DataNascimento"));
		 vend.setSalario(rs.getDouble("Salario"));
		 vend.setDepartamento(dep);
		 return vend;
	}

	private Departamento instanciaDep(ResultSet rs) throws SQLException {
		 Departamento dep = new Departamento();
		 dep.setId(rs.getInt("IdDepartamento"));
		 dep.setNome(rs.getString("NomeDep"));
		 return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> findByDepartament(Departamento departamento) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT vendedor .*, departamento.Nome as NomeDep "
					                  + "FROM vendedor  INNER JOIN departamento "
					                  + "ON vendedor.IdDepartamento = departamento.Id "
					                  + "WHERE IdDepartamento = ? "
					                  + "ORDER BY Nome");
			ps.setInt(1, departamento.getId());
			rs = ps.executeQuery();
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> mapa = new HashMap<>();
			 while (rs.next()) {
				 Departamento dep = mapa.get(rs.getInt("IdDepartamento"));
				  if (dep == null) {
					  dep = instanciaDep(rs);
					  mapa.put(rs.getInt("IdDepartamento"), dep);
				  }
				 Vendedor vend = instanciaVend(rs, dep);
				 lista.add(vend);
								 				 
			 }
			 return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

}
