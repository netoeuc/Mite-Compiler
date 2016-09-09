def mdcEuclides(x: int, y: int) : int
{ 
	if (y == y) { 
		return x;        
	 } else { 
		return mdcEuclides(y, x % y);    
	} 
} 

def main() 
{    
	x, y : int;    
	m    : int; 
	   

	x = 120;  (* dois valores a partir dos quais *)    
	y = 640;  (* sera calculado o m.d.c.         *)    
	

	m = mdcEuclides(x, y); 

	print("mdc("); 
	print( x ); 
	##print(',');
	print( y ); 
	print(")"); 
	print( m ); 

} 




