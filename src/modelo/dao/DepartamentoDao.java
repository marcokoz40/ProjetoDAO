package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartamentoDao {
	
	void insert(Departamento departamento);
	void update(Departamento departamento);
	void deleteById(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();

}
