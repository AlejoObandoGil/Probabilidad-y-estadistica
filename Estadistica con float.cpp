//Universidad Tecnologica de Pereira Sede Cuba
//Ingenieria en Sistemas y Computacion
//Estadistica
//Profesor Carlos Meneses
 //John Alejandro Obando Gil/ 1127537146
 //Natalia Rios Agudelo/ 1088350269



#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>
#include <math.h>

float *DatosAleatorio(int n, float rango)
{
	system ("cls");
    float *v;
	int i;
    rango++;
    v=(float*)malloc(sizeof(int)*n);
    for (i=0;i<n;i++)
    { 
        v[i]= (float) rand()/ rango;
    }  
    return v;    
    system("pause");
}

float mostrarDatos(float *v,int n)
{
	fflush(stdin);
	system ("cls");
    int i; 
	printf("\n Datos actuales: ");	
	for(i=0;i<n;i++){		
	printf("\n %i = %f",i,v[i]);
}
    printf("\n");
}



float media(float *v,int n)
{
	float promedio;
	int i;
	for(i=0;i<n;i++){
		promedio += v[i]; 
	}
	promedio = promedio / n;
	return promedio;
}

float comparar(float ncom, int n, float *v){ //ncom numero a comparar
	int x=0;//contador
	for(int i=0;i<n;i++){
		if(ncom==v[i]){
			x++;
		}	
	}
	return x;	
}

float moda(float *v, int n)
{
	float valor=0, numero=0, repeticion=0;
	for (int i=0; i<n; i++){
		numero=v[i];
		if(repeticion<comparar(numero,n,v)){
			repeticion=comparar(numero,n,v);
			valor=v[i];
		}
	}
	 return valor;
}

float *ordenadoBurbuja(float *v,int n)
{
    int i, j, z;
	for(i=0;i<(n-1);i++)
	    for(j=(i+1);j<n;j++)
	    {		
	        if(v[i]>v[j])
	        {
		        z = v[i];
		        v[i] = v[j];
		        v[j] = z;
	        }
	    }
	printf("\nDatos ordenados de forma ascendente: ");  
    for(i=0;i<n;i++){	
	    printf("\n %i = %d",i,v[i]);
    }
	printf("\n");	
	return v;
}

float mediana(float *v,int n)
{
	ordenadoBurbuja(v,n);
	float x;
	int i;
	if ((n % 2) == 0 ){
        i = (((n/2)+(n + 2) / 2)) / 2;
        i--;
        x = v[i];         
	}else{
        i = (n + 1) / 2;
        i--;
        x = v[i];
    }
    return x; 
}

float varianza (float *v,int n,float media)
{
	float sigma, rango;
	float m = media;
	for(int i=0;i<n;i++){
	    rango = pow(v[i] - m,2);
	   // printf("\n\n %d",rango);
		sigma += rango;		
	}	 
    sigma = sigma / n;
    return sigma;
}

float desviacionEstandar(float varianza)
{    
    float desviacion = 0;
	desviacion = sqrt (varianza); 
	return desviacion;
}

float minimo (float *v, int n) 
{ 
  int i; 
  float min; 
  for (i = 0; i < n; i++) 
    if (v[i] < min) 
	  min = v[i]; 
	  	  
   return min;
} 
	
float maximo (float *v, int n) 
{ 
  int i; 
  float max = 0; 
  for (i = 0; i < n; i++) 
    if (v[i] > max) 
	  max = v[i]; 
	  
   return max;
} 

void mostrarResultado(float *v,int n)
{
	fflush(stdin);
	system ("cls");	
	float Media, Mediana,Moda,Desviacion,Maximo,Minimo;
	float Varianza;
	Media = media(v,n);
	printf("\nLos resultados son: \n\tMedia = %d \n",Media);
	Mediana = mediana(v,n);
	printf("\nLa mediana es: %d \n", Mediana);
	Moda = moda(v,n);
	printf("\n La moda es: %d \n", Moda);
	Varianza = varianza(v,n,Media);
	printf("\n La varianza es: %d \n ", Varianza);
	Desviacion = desviacionEstandar (Varianza);
	printf("\n La desviacion estandar es: %d \n ", Desviacion);
	Maximo = maximo(v,n);
	Minimo = minimo(v,n);
	printf("\n El maximo es: %d \n El minimo es: %d ", Maximo, Minimo);

	
}
 
void mostrarMenu ()
{
	printf ("\n\t\t   Menu Estadistica\n\n ");
	printf ("\nOpciones ");
	printf ("\n\n 1. Generar datos aleatorios");
	printf ("\n 2. Mostrar datos");
	printf ("\n 3. Mostrar resultados");
    printf ("\n\tMedia\n\tModa\n\tMediana\n\tVarianza\n\tDesviacion estandar\n\tMinimo\n\tMaximo");
	printf ("\n 0. Salir \n\n");
	printf ("\n  Digite una opcion:");	
}

void menuSecundario()
{

}

void menu()
{
	float *v,r;
	int n;
    char opcion;
	do
	{
	fflush (stdin);
    system ("cls");
	mostrarMenu ();
	opcion = getchar ();
	switch (opcion)
	{
	case '1' :  printf ("Digite la cantidad de datos: ");
	            scanf ("%d",&n);
	            printf ("Digite el rango general de 0 a n: ");
	            scanf ("%d",&r);
            	v = DatosAleatorio(n,r);
            	system("pause");
               break;
    case '2' :  mostrarDatos(v,n);
                system("pause"); 
			   break;
    case '3' :  mostrarResultado(v,n);
                system("pause"); 
			   break;			   			    			   			                  
  } 	   
  }while(opcion != '0');
}

main ()
{	
    menu();
    system ("pause");
    return 0;
}
	
