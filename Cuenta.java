package bank.code;

import java.util.Scanner;

public class Cuenta {
//variables
	private int balance; 
	private int transaccionPrevia;
	private String nombreCliente;
	private String idCliente;

//constructor
	public Cuenta(int balance, int transaccionPrevia, String nombreCliente, String idCliente) {
		this.balance = balance;
		this.transaccionPrevia = transaccionPrevia;
		this.nombreCliente = nombreCliente;
		this.idCliente = idCliente;
	}
	
	public Cuenta(String nombreCliente, String idCliente) {
		this.nombreCliente = nombreCliente;
		this.idCliente = idCliente;
	}
	
	public Cuenta() {
	}

//m�todos getter y setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

//	public int getTransaccionPrevia() {
//		return transaccionPrevia;
//	}

	public void setTransaccionPrevia(int transaccionPrevia) {
		this.transaccionPrevia = transaccionPrevia;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

//m�todos especificos
	
	//depositar dinero
	void depositarDinero(int cantidad) {
		if(cantidad != 0) {
			balance = balance + cantidad;
			transaccionPrevia = cantidad;
		}
	}
	
	//retirar dinero
	void retirarDinero(int cantidad) {
		if(cantidad != 0) {
			balance = balance - cantidad;
			transaccionPrevia = -cantidad; //el monto negativo
		}
	}
	
	//mostrar transaccion realizada
	void getTransaccionPrevia() {
		if (transaccionPrevia > 0) {
			System.out.println("Depositaste: "+ transaccionPrevia);
		} else if(transaccionPrevia < 0){
			System.out.println("Retiraste: "+ Math.abs(transaccionPrevia)); //Returns the absolute value of an int value.If the argument is not negative, the argument is returned.If the argument is negative, the negation of the argument is returned.
		} else {
			System.out.println("No realizaste ninguna transacci�n");
		}
	}
	
	//calcular interes luego de unos a�os
	void calcularInteres(int years) {
		double tasaInteres = .03;
		double nuevoBalance = (balance * tasaInteres * years) + balance;
		System.out.println("La tasa de inter�s es de: "+ (100* tasaInteres)+"%");
		System.out.println("En "+years+ " a�os, tu balance ser� de "+nuevoBalance);
	}
	
	//mostrar men� principal
	void mostrarMenu() {
		char opcion = '\0';
		Scanner teclado = new Scanner(System.in);
		System.out.println("Bienvenida "+nombreCliente+ "!");
		System.out.println("Tu ID de cliente es "+ idCliente);
		System.out.println();
		System.out.println("�Qu� deseas hacer?");
		System.out.println();
		System.out.println("A. Consultar balance de cuenta.");
		System.out.println("B. Realizar un ingreso de dinero.");
		System.out.println("C. Retirar dinero.");
		System.out.println("D. Ver �ltima transacci�n.");
		System.out.println("E. Calcular inter�s.");
		System.out.println("F. Salir.");
		
		do {
			System.out.println();
			System.out.println("Ingresa un opci�n: ");
			char opcion1 = teclado.next().charAt(0); //por si el usuario ingresa opcion en lowercase
			opcion = Character.toUpperCase(opcion1);
			System.out.println();
			
			
			switch (opcion) {
			case 'A': 
				System.out.println("Balance = $"+balance);
				break;
			case 'B': 
				System.out.println("Ingresa la cantidad a depositar: ");
				int cantidad = teclado.nextInt();
				depositarDinero(cantidad);
				break;
			case 'C': 
				System.out.println("Ingresa la cantidad que deseas retirar: ");
				int cantidad2 = teclado.nextInt();
				retirarDinero(cantidad2);
				break;
			case 'D': 
				System.out.println("�ltima transacci�n: ");
				getTransaccionPrevia();
				break;
			case 'E': 
				System.out.println("Ingresa la cantidad de a�os de inter�s acumulado: ");
				int years = teclado.nextInt();
				calcularInteres(years);
				break;
			case 'F': 
				System.out.println("�Hasta pronto " + nombreCliente +"!");
				break;
			default:
				System.out.println("Error: la opci�n ingresada no es v�lida");
				break;
			}
		} while(opcion != 'F');
		System.out.println("�Gracias por confiar en nosotros!");
		}
}
