#ifndef NO_H
#define NO_H

typedef struct no No;

void inserir_inicio(No **lista, int num);
void inserir_fim(No **lista, int num);
void inserir_meio(No **lista, int num, int ant);
void inserir_ordenado(No **lista, int num);
void imprimir(No *lista);

#endif

