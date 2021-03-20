package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Trabalhador {
	private Integer id;
	private String name;
	private WorkLevel level;
	private Double baseSalario;
	
	private Departament departamento;
	private List<HourContract> contracts = new ArrayList<>();;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Trabalhador() {
		
	}
	
	public Trabalhador(Integer id, String name, WorkLevel level, Double baseSalario, Departament departamento) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
		//this.sdf = sdf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(Double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departament getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departament departamento) {
		this.departamento = departamento;
	}
	
	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContrato(HourContract contract) {
		contracts.add(contract);
	}
	
	public double income(int ano, int mes) {
		double soma = this.getBaseSalario();
		Calendar cal = Calendar.getInstance(); 
		for(HourContract hc : contracts) {
			cal.setTime(hc.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1+cal.get(Calendar.MONTH);
			if(ano == c_year && mes == c_month) {
				soma += hc.totalValor();
			}
		}
		return soma;
	}
	
	public void removerContrato(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	
}
