def somaImpares(n: int) : int 
{    
	i, proxImpar, resultado : int;    
	
	resultado = 0;    
	i = 0; 

	while (i < n) {  
	     proxImpar = 2*i + 1;  ## o i-esimo impar positivo      
	     resultado = resultado + proxImpar;
	     i = i + 1;    
	} 
	print(resultado); 
	print('\n'); 
	return resultado;}

n, soma : int; 

def main() 
{    
	n = 9;  ## quantidade de numeros impares positivos 
	call somaImpares(n); 
} 
	



