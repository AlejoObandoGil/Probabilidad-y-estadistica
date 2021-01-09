/*
Clase control:
Donde implementamos las funciones necesarias para encontrar
la media, mediana, moda, desviacion estandar etc y las frecuncias
y demas datos probabilisticos

 */
package probabilidad.y.estadistica.frecuencia;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Random;


public class Control {
    private float vector[];
    private int tamaño;
    private int rango2;

    public Control() {
    }    
      
    public float[] DatosAleatorio(int n, int rango2)
    {
        this.rango2 = rango2;
        float v[] = new float[n];
        Random aleatorio = new Random ();
        for (int i=0;i<n;i++)
        { 
            v[i] = aleatorio.nextInt(rango2);
        }
        return v;
    }  
        
    public float mostrarDatos(float v[], int n)
    { 
	System.out.println("\n Datos actuales: ");	
	for(int i=0;i<n;i++){		
	    System.out.println(i+" | "+v[i]);
        }
        return 0;
    }
    
    public void mostrarResultado(float v[],int n)
    {	
	float Media, Mediana,Moda,Desviacion,Maximo,Minimo,Varianza;
        float burbuja[] = ordenadoBurbuja(v,n);
	System.out.println("\nDatos ordenados de forma ascendente: ");  
        for(int i=0;i<n;i++){	
	    System.out.println(i+" = "+burbuja[i]);
        }
	Media = media(v,n);
	System.out.print("\nLos resultados son: \n\n Media = "+Media);
	Mediana = mediana(v,n);
	System.out.print("\n La mediana es = "+Mediana);
	Moda = moda(v,n);
	System.out.print("\n La moda es = "+Moda);
	Varianza = varianza(v,n,Media);
	System.out.print("\n La varianza es = "+Varianza);
	Desviacion = desviacionEstandar (Varianza);
	System.out.print("\n La desviacion estandar es = "+Desviacion);
	Maximo = maximo(v,n);
        System.out.print("\n El maximo es = "+Maximo);
	Minimo = minimo(v,n);
	System.out.print("\n El minimo es = "+Minimo);
    }
    
    public void mostrarFrecuencias(float v[], int n)
    {
        float FrecAbsoluta[], FrecRelativa[], FrecAcumulada[], sumaFrecAbsoluta;
        int enteros[] = new int[n];
        int r = rango2;
        
        for(int i=0;i<n;i++){//convertimos a enteros
            enteros[i] = (int) v[i];
        }        
        FrecAbsoluta = frecAbsoluta(enteros,n,r);
        FrecRelativa = frecRelativa(enteros,n,r);
        FrecAcumulada = frecAcumulada(enteros,n,r);
        System.out.println("  datos\t  frec absoluta frec relativa frec acumulada");        
        for(int i=0;i<FrecAbsoluta.length;i++){
            System.out.println("-   "+i+"    |    "+FrecAbsoluta[i]+"    |    "+FrecRelativa[i]+"     |      "+FrecAcumulada[i]);          
        }
            System.out.println("         |    " + FrecAcumulada[FrecAbsoluta.length-1]);  
    }


    public float media(float v[], int n)
    {
	float promedio = 0;
	for(int i=0;i<n;i++){
		promedio += v[i]; 
	}
	promedio = promedio / n;
        
	return promedio;
    }
    
    public float comparar(float v[], float ncom, int n)//ncom numero a comparar
    { 
	int c=0;//contador
	for(int i=0;i<n;i++){
	    if(ncom == v[i]){
		c++;
	    }	
	}
	return c;	
    }
    public float moda(float v[], int n)
    { 
        float valor=0, numero=0, repeticion = 0;
	for (int i=0;i<n;i++){
            numero = v[i];
	    if(repeticion < comparar(v,numero,n)){
		repeticion = comparar(v,numero,n);
		valor = v[i];
            }
	}
	return valor;
    }

    public float[] ordenadoBurbuja(float v[],int n)
    {
        int i, j;
        float z;
	for(i=0;i<(n-1);i++)
	    for(j=(i+1);j<n;j++){
	        if(v[i]>v[j]){
		    z = v[i];
		    v[i] = v[j];
                    v[j] = z;
	        }
	    }
	return v;
    }
    public float mediana(float v[],int n)
    {
	ordenadoBurbuja(v,n);
	float x;
	int i;
	if ((n % 2) == 0 ){
            i = (((n/2)+(n + 2) / 2)) / 2;
            i--;
            x = v[i];         
	}
        else{
            i = (n + 1) / 2;
            i--;
            x = v[i];
        }
        return x; 
    }

    public float varianza (float v[],int n,float media)
    {
	float sigma = 0, rango;
	float m = media;
	for(int i=0;i<n;i++){
	    rango = (float) pow(v[i] - m,2);
		sigma += rango;		
	}	 
        sigma = sigma / n;
        
        return sigma;
    }

    public float desviacionEstandar(float varianza)
    {    
        float desviacion = 0;
	desviacion = (float) sqrt (varianza); 
        
	return desviacion;
    }

    public float minimo (float v[], int n) 
    { 
        float min = v[0]; 
        for (int i = 1; i < n; i++)   
            if (v[i] < min) 
	        min = v[i]; 
	  	  
        return min;
    } 
	
    public float maximo (float v[], int n) 
    { 
        int i; 
        float max = 0; 
        for (i = 0; i < n; i++) 
            if (v[i] > max) 
	        max = v[i]; 
	  
        return max;
    } 
    
    public float[] frecAbsoluta(int v[],int n,int r)
    {
        int numVector;
        float contador[] = new float[r];
        for(int i=0;i<n;i++){
            numVector = v[i]; 
            contador[numVector] += 1;            
        }        
        return contador; 
    }   
    
    public float[] frecRelativa(int v[],int n,int r)
    {    
        r = rango2;
        float fAbs[] = frecAbsoluta(v,n,r);
        float fRelativa[] = new float[r];
        for(int i=0;i<r;i++){
            fRelativa[i] = fAbs[i]/n;
        }
        return fRelativa;
    }
    
    
    public float[] frecAcumulada (int v[],int n,int r)
    {     
        float frecAbs[] = frecAbsoluta(v,n,r);
        float frecAcumulada[] = new float[r];
        float suma = 0;
        for (int i=0;i<r;i++){
            suma += frecAbs[i];
            frecAcumulada[i] = suma;
        }
        return frecAcumulada;
    }
    
     public float factorial (float n ){
        float resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
     
     
    public float distriBinomial (float p, float n, float k, float q ){
      
      float resultado = 0;
      float resta = n-k;   
      float operacion = factorial(n) / (factorial(k) * factorial(resta));
      resultado = (float) (operacion * pow(p, k) * pow(q, resta));
        System.out.println("Resultado:" +resultado);
      return resultado;
      
    }
   

    

}

    
    /*public int existe(float v[],int n, float numero)
    {
        int c = 0;
        for(int i=0;i<n;i++){
            numero = v[i];
            for(int j=0;j<n;j++){
                if(numero == j) 
                   c++;
                   break;
            }
        }    
        return c;
    }
    
    /*public float[] frecuencia(float v[],int n)
    {
        float frecuencia[] = null;
        float numero = 0;
        int c = 0;
        for(int i=0;i<n;i++){
            numero = v[i];
            if(existe(v,n,numero))
            for(int j=0;j<n;j++){
                if(numero == v[j]){
                    c++;
                    frecuencia[] = c;
                }
            }
        }
        return frecuencia;       
    }*/
      

