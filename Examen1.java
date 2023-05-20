import java.util.Scanner;
public class Examen1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Hacer un programa que permita agregar x cantidad de productos con:
		 * 1) Nombre del producto
		 * 2) Precio
		 * 3) Cantidad

		 * - IVA 15%
		 * - Precio del dolar
		  
		 * A Realizar:
		 * Producto mas costoso (Bs - $)
		 * Producto menos costoso (Bs - $)
		 * Producto con mayor cantidad 
		 * Producto con menor cantidad 
		 * Total Neto (Bs - $)
		 * Total Bruto (Bs - $) 
		 */
		
		 double IVA = 0.15, dollar = 26.00, price = 0;
	        int qty = 0;
	        
	        String nombre_producto;
	        double max = 0, min= 0;
	        double neto_Bs = 0, neto_dollar = 0;
	        double bruto_Bs = 0, bruto_dollar = 0;

	        System.out.print("Ingrese la cantidad de productos: ");
	        int obj = sc.nextInt();

	        for (int i = 0; i < obj; i++) {
	            System.out.print("Ingresa el nombre del producto " + (i + 1) + ": ");
	            nombre_producto = sc.next();

	            System.out.print("Ingresa el precio del producto " + (i + 1) + ": ");
	            price = sc.nextDouble();

	            System.out.print("Cuantos hay en stock del producto " + (i + 1) + ": ");
	            qty = sc.nextInt();

	            if (price > max) {
	                max = price;
	            }

	            if (price < min || i == 0) {
	                min = price;
	            }
	            
	          neto_Bs += price * qty;
	          neto_dollar += (price * qty) / dollar;
	       
	        }

	        int option = 0;
	        System.out.println("Ingrese a la opcion que desea analizar: ");
	        System.out.println("1) Producto mas costoso (Bs - $)");
	        System.out.println("2) Producto menos costoso (Bs - $)");
	        System.out.println("3) Producto con mayor cantidad");
	        System.out.println("4) Producto con menor cantidad");
	        System.out.println("5) Total Neto (Bs - $)");
	        System.out.println("6) Total Bruto (Bs - $)");

	        option = sc.nextInt();

	        switch (option) {
	            case 1:
	                System.out.print("El producto más costoso tiene un valor de: " + max + " en Bs, en divisas: " + (max / dollar));
	                break;
	            case 2:
	                System.out.print("El producto menos costoso tiene un valor de: " + min + " en Bs, en divisas: " + (min / dollar));
	                break;
	            case 3:
	               System.out.print("El producto con más stock ");
	                break;
	            case 4:
	               
	                break;
	            case 5:
	                System.out.print("El Total Neto es de: " + (neto_Bs + (neto_Bs * IVA)) + " en Bs, en divisas: " + (neto_dollar + (neto_dollar * IVA)));
	                break;
	            case 6:
	            	System.out.print("El Total Bruto es de: " + neto_Bs + "en Bs, en divisas: " + neto_dollar);
	                break;
	            default:
	                System.err.println();
	        }
	    }
	}
