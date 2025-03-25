#ifndef NO
#define NO
#include "No.h"

typedef struct no{
	int valor;
	struct no *proximo;
}No;

typedef struct{
	No *inicio;
	No *fim;
	int tam;
}Lista;

#endif
