
#include <stdio.h>
 float fixaA = 17.61;//taxa fixa de água
 float fixaE = 13.03;//taxa fixa de esgoto
float fixaTotal=0;
float consumo=0;

float faixa1()//Faixa 1 detalha o consumo para zero metros cúbicos e possibilita a passagem das taxas fixas para as próximas funções. 
  {
    fixaTotal = fixaA + fixaE;
    return fixaTotal;
  }
float faixa2(float consumo)//utiliza o gasto zero(taxas fixas) adicionando o consumo nesta faixa com o peso devido.
  {
    consumo = faixa1()+((1.820 + 1.350)*(consumo));
    return consumo;
  }
float faixa3(float consumo)//efetua o cálculo para o que exceder ao consumo da faixa 2 e chama a função faixa 1 para cálculo no valor de 5. As próximas funções tem função parecida.
  {
    consumo = faixa2(5)+((3.886 + 2.876)*(consumo-5));
    return consumo;
  }
float faixa4(float consumo)
  {
    consumo = faixa3(10)+((6.023 + 4.457)*(consumo-10));
    return consumo;
  }
float faixa5(float consumo)
  {
    consumo = faixa4(15)+((8.222 + 6.084)*(consumo-15));
    return consumo;
  }
float faixa6(float consumo)
  {
    consumo = faixa5(20)+((10.458 + 7.739)*(consumo-20));
    return consumo;
  }
float faixa7(float consumo)
  {
    consumo = faixa6(40)+((12.759 + 9.441) * (consumo-40));
    return consumo;
  }
int main(void)
  {
    float gasto;
    printf("Informe o consumo em metros cúbicos:\n");
    scanf("%f", &consumo);//lê o consumo da conta 
    if (consumo < 0)//filtra se o valor informado está fora do domínio da função e apresenta mensagem de erro.
      {
        printf("valor informado incorretamente");
      }

    else if (consumo == 0)
      {
        gasto = faixa1();
        printf("Conta sem uso de água, taxa mínima de água é R$%.3f", gasto);
      }
    else 
    {
        gasto = faixa7(consumo); 
      }
  return 0;
  }