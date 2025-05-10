#include <stdio.h>
#include "hash.h"

#define TAM 15 

int main(void){
	int opcao, valor, retorno;
	Pessoa *buscar, tabela[TAM];
	
	inicializarTabela(tabela, TAM);
	
	do{
		printf("\n0 - SAIR\n1 - INSERIR\n2 - BUSCAR\n4 - IMPRIMIR\n");
		scanf("%d", &opcao);
		getchar();
	}
	
	switch(opcao){
		case 1: 
		inserir(tabela, tam);
		break;
		
		case 2: 
		printf("\nCPF: ");
		scanf("%d", &valor);
		buscar = busca(tabela, valor, TAM);
		if(buscar){
			printf("\nCPF encontrado\n");
			imprimirPessoa(*buscar);
		}else{
			printf("\nCPF não encontrado.\n");
		break;
		}
		
		case 3:
		imprimir(tabela, TAM);
		break;
		
		default:
			printf("\nOpção inválida.\n");
		
	} while (opcao != 0);
}
