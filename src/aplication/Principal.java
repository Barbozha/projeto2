package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Departament;
import entities.HourContract;
import entities.Trabalhador;
import entities.enums.WorkLevel;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). 
		// Depois, solicitar do usuário um mês e mostrar qual foi o salário do 
		// funcionário nesse mês
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		int codFunc;
		int idDep;
		int qtdContrato;
		String dep;
		String nome;
		String nivel;
		double salarioBase;
		double valHora;
		int qtdHoras;
		System.out.print("Informe o Id do Departamento: ");
		idDep = sc.nextInt();
		System.out.print("Enter department's name:");
		sc.nextLine();
		dep = sc.nextLine();
		Departament depart = new Departament(idDep, dep);
		System.out.println("Enter worker data:");
		System.out.print("Código do Funcionário: ");
		codFunc = sc.nextInt();
		sc.nextLine();
		System.out.print("Name: ");
		nome = sc.nextLine();
		System.out.println("Level: ");
		nivel = sc.nextLine();
		System.out.print("Base salary: ");
		salarioBase = sc.nextDouble();
		Trabalhador trab = new Trabalhador(codFunc, nome,WorkLevel.valueOf(nivel) , salarioBase, depart);
		
		System.out.print("How many contracts to this worker? ");
		qtdContrato = sc.nextInt();
		for(int i=1 ; i <= qtdContrato ; i++) {
			System.out.println("Enter contract #"+i+" data:");
			System.out.print("Date (DD/MM/YYYY):");
			Date dataCont = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			valHora = sc.nextDouble();
			System.out.print("Duration (hours): ");
			qtdHoras = sc.nextInt();
			//@SuppressWarnings("unused")
			HourContract horaContrato = new HourContract(dataCont, valHora, qtdHoras);
			trab.addContrato(horaContrato);
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String dataCalc = sc.next();
		int mm = Integer.parseInt(dataCalc.substring(0, 2));
		int aa = Integer.parseInt(dataCalc.substring(3));
		trab.income(aa, mm);
		System.out.println("Código do Funcionário: "+trab.getId());
		System.out.println("Name: "+trab.getName());
		System.out.println("Departamento: "+trab.getDepartamento().getNome());
		System.out.println("Income for "+dataCalc+": "+String.format("%.2f%n",trab.income(aa, mm)));
		
		
		
		sc.close();
	}

}
