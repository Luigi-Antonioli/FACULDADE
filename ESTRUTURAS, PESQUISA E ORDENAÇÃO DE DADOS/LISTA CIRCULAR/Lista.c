#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void criar_lista(Lista *lista){
	lista->inicio = NULL;
	lista->fim = NULL;
	lista->tam = 0;
}

void inserir_inicio(Lista *lista, int num){
	No *novo = malloc(sizeof(No));
	
	if(novo){
		novo = num;
		novo->proximo = lista->inicio;
		lista->inicio = novo;
		if(lista->fim == NULL){
			lista->fim = novo;
			lista->fim->proximo = lista->inicio;
			lista->tam++;
		}else{
			printf("Erro ao alocar memória.\n")
		}
	}
}

void inserir_fim(Lista *lista, int num){
	No *aux, *novo = malloc(sizeof(No));
	
	if(novo){
		novo->valor = num;
		if(lista->inicio = NULL){
			lista->inicio = novo;
			lista->fim = novo;
			lista->fim->proximo = lista->inicio;
		}else{
			lista->fim->proximo = novo;
			lista->fim = novo;
			novo->proximo = lista->inicio;
		}
		lista->tam++;
	}else{
		printf("Erro ao alocar memória.\n");
	}
}

vvoid inserir_ordenado(Lista *lista, int num){
	No *aux, *novo = malloc(sizeof(No));
	
	if(novo){
		novo->valor = num;
		if(lista->inicio == NULL){
			inserir_inicio(lista, num);
		}else if(novo->valor < lista->inicio->valor){
			inserir_inicio(lista, num);
		}else{
			aux = lista->inicio;
			while(aux->proximo != lista->inicio && novo->valor > aux->proximo->valor){
				aux = aux->proximo;
			if(aux->proximo == lista->inicio){
				inserir_fim(lista, num);
			}else{
				novo->proximo = aux->proximo;
				aux->proximo = novo;
				lista->tam++;
			}
			}
		}
	}else{
		printf("Erro ao alocar memória.\n");
	}
}

No *remover(Lista *lista, int num){
	No *aux, *no = NULL;
	
	if(lista->inicio){
		if(lista->inicio == lista->fim && lista->inicio->valor == num){
			no = lista->inicio;
			lista->inicio = NULL;
			lista->fim = NULL;
			lista->tam--;
		}else if(lista->inicio->valor == num){
			no = lista->inicio;
			lista->inicio = no->proximo;
			lista->fim->proximo = lista->inicio;
			lista->tam--;
		}else{
			aux = lista->inicio;
			while(aux->proximo != lista->inicio && aux->proximo-valor != num){
				aux = aux->proximo;
				if(aux->proximo->valor == num){
					if(lista->fim == aux->proximo){
						no = aux->proximo;
						aux->proximo = no->proximo;
						lista->fim = aux;
					}else{
						no = aux->proximo;
						aux->proximo = no->proximo;
					}
					lista->tam--;
				}	
			}
		}
	}
	return no;
}
