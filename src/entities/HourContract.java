package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {
	private Date date;
	private Double valorPorHora;
	private Integer horas;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public HourContract() {
		
	}
	
	public HourContract(Date date, Double valorPorHora, Integer horas) {
		this.date = date;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double totalValor() {
		return this.getValorPorHora() * this.getHoras(); 
	}
	
	
}
