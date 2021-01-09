/*
Clase menu y main
 */
package probabilidad.y.estadistica.frecuencia;

import java.util.Scanner;


public class Principal {
    
    public static void mostrarMenu(){
        
        System.out.println("\n\t\t Menu probabilidad y estadistica " );
        System.out.println("\nOpciones");
        System.out.println("\n 1. Menu distribucion binomial ");
        System.out.println(" 2. Menu estadistica y frecuencias");
        
    }
    public static void mostrarMenu2 ()
            
    {
	System.out.println("\n\t\t   Menu Estadistica ");
	System.out.println("\nOpciones ");
	System.out.println("\n 1. Generar datos aleatorios");
	System.out.println(" 2. Mostrar datos");
	System.out.println(" 3. Encontrar");
        System.out.println("\tMedia\n\tModa\n\tMediana\n\tVarianza\n\tDesviacion estandar\n\tMinimo\n\tMaximo");        
        System.out.println(" 4. Encontrar frecuencias");
        System.out.println("\tFrecuencia absoluta\n\tFrecuencia relativa\n\tFrecuencia acumulada");
	System.out.println("\n 0. Salir ");
	System.out.print("\n  Digite una opcion:");	
    }
    
    public static void menu2(){
         Scanner entrada = new Scanner (System.in);
        Control control = new Control();
	float v[] = null;
	int n = 0, r2, opcion = 0;
	do{
	    mostrarMenu2();
	    opcion = entrada.nextInt();
	    switch (opcion){
	    case 1 :  System.out.print("Digite la cantidad de datos: ");
	                n = entrada.nextInt();
	                System.out.print("Digite el rango general de 0 a n: ");
	                System.out.print("Rango = ");
                        r2 = entrada.nextInt();                        
            	        v = control.DatosAleatorio(n,r2);
                       break;
            case 2 :  control.mostrarDatos(v,n);
	       	       break;
            case 3 :  control.mostrarResultado(v,n);
	       	       break;
            case 4 :  control.mostrarFrecuencias(v, n);
                       break;
            default: System.out.println("\nOpcion Invalida!");                
            } 	   
      }while(opcion != '0');
    }
    
    
   public static void main(String[] args)
    {
        Scanner entrada = new Scanner (System.in);
        Control control = new Control();
	float v[] = null;
	int opcion = 0;
        float p = 0;
        float n = 0;
        float k = 0;
        float q = 0;
        
	do{
	    mostrarMenu();
	    opcion = entrada.nextInt();
	    switch (opcion){
	    case 1 :  System.out.println("Digite los datos para la distribucion binomial: ");
                        System.out.print("Digite p: ");
	                p = entrada.nextFloat();
                        System.out.print("Digite q: ");
	                q = entrada.nextFloat();
                        System.out.print("Digite n: ");
	                n = entrada.nextFloat();
                        System.out.print("Digite k: ");
	                k = entrada.nextFloat();
                        control.distriBinomial(p,n,k,q);
	       	       break;
            case 2 :   menu2(); 
                       break;
            default: System.out.println("\nOpcion Invalida!");                
            } 	   
      }while(opcion != '0');
    }
  
}
