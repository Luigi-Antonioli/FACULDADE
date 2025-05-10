#include <stdio.h>
#include "hash.h"

void inicializarTabela(Pessoa t[], int tam){
	int i;
	
	for(i=0;i<tam;i++){
		t[i].cpf = 0;
	}
	
	int funcaoHash(int chave, int tam){
		return chave % tam;
	}
}

void inserir(Pessoa t[], int tam){
	Pessoa p;
	p = lerPessoa();
	int id = funcaoHash(p.cpf, int tam);
		while(t[id].cpf != 0){
			id = funcaoHash(id + 1, tam);
		}
		t[id] = p;
}

Pessoa* busca(Pessoa t[], int chave, int tam){
	int id = funcaoHash(chave, tam);
	printf("\nIndice gerado: %d\n", id);
	while(t[id].cpf !=0){
		if(t[id].cpf == chave){
			return &t[id];
		}else{
			id = funcaoHash(id + 1, tam);
		}
	}
	return NULL;
}

void imprimir(Pessoa t[], int tam){
	int i;
	for(i=0;i<tam;i++){
		printf("%d\n", i);
		if(t[id].cpf != 0){
			imprimirPessoa(t[i]);
			printf("\n---------\n");
		}
	}
}
