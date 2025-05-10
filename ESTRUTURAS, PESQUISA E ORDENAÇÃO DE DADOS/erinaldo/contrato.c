#include <stdio.h>
#include "contrato.h"

void imprimirContrato(Contato c){
	printf("\nDados do Contrato\n");
	printf("\nContrato: %d", c.codigo);
	printf("\nCargo: %s", c.cargo);
	printf("\nSal�rio R$: %.2f", c.salario);
	printf("\nData de admiss�o: ");
	imprimirData(c.dataAss);

}

Contrato lerContrato(){
	Contrato c;
	printf("\nC�digo do contrato: ");
	scanf("%d", &c.codigo);
	printf("\nData de assinatura: ");
	c.dataAss = lerData();
	printf("\nCargo: ");
	fgets(c.cargo, 49, stdin);
	printf("\nSal�rio: R$");
	scanf("%f", &c.salario);
	getchar();
	return c;
}
