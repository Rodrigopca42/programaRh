package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rhPrograma.Funcionarios;

public class AppRh {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		List<Funcionarios>  funcion = new ArrayList<>();
		
		System.out.print("Quantos funcionários vão ser registrados? ");
		int n = tec.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Funcionário #" + (i + 1)+ ":");
			
			System.out.print("Id: ");
			Integer id = tec.nextInt();
			
			System.out.print("Nome: ");
			tec.nextLine();
			String nome = tec.nextLine();
			
			System.out.print("Salario: R$");
			Double salario = tec.nextDouble();
			
			Funcionarios fun = new Funcionarios(id, nome, salario);
			
			funcion.add(fun);
		}
		
		System.out.println("");
		System.out.print("Entrar com o id do funcionário que vai receber o aumento");
		int idFuncionario = tec.nextInt();
		Integer pos = positionId(funcion, idFuncionario);
		if (pos == null) {
			System.out.println("Esse id não existe:");
		}
		else {
			System.out.print("Quantos porcento vai ser o aumento? ");
			double porcentagem = tec.nextDouble();
			funcion.get(pos).aumentoDeSalario(porcentagem);
		}
		
		System.out.println("");
		System.out.println("Lista de funcionários ");
		
		for(Funcionarios fun: funcion) {
			System.out.println(fun);
		}
		
		tec.close();
	}
	
	public static Integer positionId(List<Funcionarios> funcion, int id) {
		
		for(int i = 0; i < funcion.size(); i++) {
			if(funcion.get(i).getId() == id) {
				return i;
			}
				
		}
		return null;
	}
	
}




















