def main()



at0 = 51423

n = at0

expA2 = n
expA4 = 2

expA5 = 1

expA3=expA4 + expA5
expA0=expA2 / expA3
expA1 = 2

at1=expA0 * expA1
nRebuilt = at1

exprRelacional0 = n
exprRelacional1 = nRebuilt
dec0=exprRelacional0 == exprRelacional1

varIf0 = dec0
ifFalse varIf0 goto LElse1
at2 = "par"

msg = at2

goto LDepois1
LElse1
at3 = "impar"

msg = at3

LDepois1

esc0 = msg
param esc0
call print

.end function 

