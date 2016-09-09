def main() 
{    
	n,nRebuilt: int;  
	msg : string;    

	n = 51423;  ## numero a ser testado    
	(* A divisao de inteiros arredonda para baixo (em caso        
	de divisao inexata). Assim, numeros impares ficarao       
	com uma unidade a menos do que seu valor inicial. *)    

	nRebuilt = (n / (2+1)) * 2; 

	if ( n == nRebuilt )       
		msg = "par"; 
	else       
		msg = "impar"; 
	print(msg);  

}