#include <stdio.h>
#include <stdlib.h>
#include <No.c>

typedef struct no{
	int valor;
	struct no *proximo;
}No;

void inserir_inicio(No **lista, int num);

void inserir_fim(No **lista, int num);

void inserir_meio(No **lista, int num, int ant);

void inserir_ordenado(No **lista, int num);
