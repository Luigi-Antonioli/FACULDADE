#include <stdio.h>
#include <stdlib.h>
#include "No.h"

typedef struct no {
    int valor;
    struct no *proximo;
} No;

// Função para inserir no início
void inserir_inicio(No **lista, int num) {
    No *novo = malloc(sizeof(No));
    
    if (novo) {
        novo->valor = num;
        novo->proximo = *lista;
        *lista = novo;
    } else {
        printf("Erro ao alocar memória.\n");
    }
}

// Função para inserir no fim
void inserir_fim(No **lista, int num) {
    No *aux, *novo = malloc(sizeof(No));
    
    if (novo) {
        novo->valor = num;
        novo->proximo = NULL;
        
        if (*lista == NULL) {    
            *lista = novo;
        } else {
            aux = *lista;
            while (aux->proximo) {
                aux = aux->proximo;
            }
            aux->proximo = novo;
        }
    } else {
        printf("Erro ao alocar memória.\n");
    }
}

// Função para inserir no meio
void inserir_meio(No **lista, int num, int ant) {
    No *aux, *novo = malloc(sizeof(No));
    
    if (novo) {
        novo->valor = num;
        
        if (*lista == NULL) {
            novo->proximo = NULL;
            *lista = novo;
        } else {
            aux = *lista;
            while (aux->valor != ant && aux->proximo) {
                aux = aux->proximo;
            }
            if (aux->valor == ant) {
                novo->proximo = aux->proximo;
                aux->proximo = novo;
            } else {
                printf("Valor de referência não encontrado.\n");
                free(novo);
            }
        }
    } else {
        printf("Erro ao alocar memória.\n");
    }
}

// Função para inserir de forma ordenada
void inserir_ordenado(No **lista, int num) {
    No *aux, *novo = malloc(sizeof(No));
    
    if (novo) {
        novo->valor = num;
        
        if (*lista == NULL || novo->valor < (*lista)->valor) {
            novo->proximo = *lista;
            *lista = novo;
        } else {
            aux = *lista;
            while (aux->proximo && novo->valor > aux->proximo->valor) {
                aux = aux->proximo;
            }
            novo->proximo = aux->proximo;
            aux->proximo = novo;
        }
    } else {
        printf("Erro ao alocar memória.\n");
    }
}

// Função para imprimir a lista
void imprimir(No *lista) {
    printf("\nLista: ");
    No *aux = lista;
    while (aux) {
        printf("%d ", aux->valor);
        aux = aux->proximo;
    }
    printf("\n\n");
}

