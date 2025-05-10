#ifndef PESSOA 
#define PESSOA 

#include "data.h"
#include "endereco.h"
#include "contrato.h"

typedef struct{
	char nome[50];
	int cpf;
	Data dataNas;
	Endereco end;
	Contrato contr;
}Pessoa;

void imprimirPessoa(Pessoa p);

Pessoa lerPessoa();

#endif
