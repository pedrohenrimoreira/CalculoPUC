public class Calculo{
  static double faixaF(double vet[]) // Faixa 1 detalha o consumo para zero metros cúbicos

  {
    double fixaAgua = 17.61; // taxa fixa de água
    double fixaEsgoto = 13.03; // taxa fixa de esgoto
    double fixaTotal = fixaAgua + fixaEsgoto;
    System.out.println(" TAXA FIXA:            de esgoto R$"+ fixaEsgoto +"            de águ10a R$"+ fixaAgua);
    System.out.println("Faixa de consumo:     Gasto em m³         Valor ");
    vet[0] = fixaTotal;
    return 0;
  }
  
  static double faixa2(double consumo, double vet[])
  {
    if (consumo > 0) {
      faixaF(vet);
      vet[1] = (1.820 + 1.350) * consumo;
      System.out.println("Faixa entre 0m³ e 5m³      " + consumo + "      R$" + vet[1]);
      return 0;
    } else {
      faixaF(vet);
      vet[1] = (1.820 + 1.350) * consumo;
      System.out.println("Faixa entre 0m³ e 5m³      " + consumo + "      R$" + vet[1]);
      return 0;
    }
  }
  
  static double faixa3(double consumo, double vet[]) {
    double cfaixa = consumo - 5;
    if (consumo > 5) {
      faixa2(5, vet);
      vet[2] = (3.886 + 2.876) * cfaixa;
      System.out.println("Faixa entre 5m³ e 10m³     " + cfaixa + "      R$" + vet[2]);
      return 0;
    } else {
      faixa2(consumo, vet);
      cfaixa = 0;
      vet[2] = (3.886 + 2.876) * cfaixa;
      System.out.println("Faixa entre 5m³ e 10m³     " + cfaixa + "      R$" + vet[2]);
      return 0;
    }
  }
  
  static double faixa4(double consumo, double vet[]) {
    double cfaixa = consumo - 10;
    if (consumo > 10) {
      faixa3(10, vet);
      vet[3] = (6.023 + 4.457) * cfaixa;
      System.out.println("Faixa entre 10m³ e 15m³    " + cfaixa + "      R$" + vet[3]);
      return 0;
    } else {
      faixa3(consumo, vet);
      cfaixa = 0;
      vet[3] = (6.023 + 4.457) * cfaixa;
      System.out.println("Faixa entre 10m³ e 15m³     " + cfaixa + "     R$" + vet[3]);
      return 0;
    }
  }
  
  static double faixa5(double consumo, double vet[]) {
    double cfaixa = consumo - 15;
    if (consumo > 15) {
      faixa4(15, vet);
      vet[4] = (8.222 + 6.084) * cfaixa;
      System.out.println("Faixa entre 15m³ e 20m³    " + cfaixa + "      R$" + vet[4]);
      return 0;
    } else {
      faixa4(consumo, vet);
      cfaixa = 0;
      vet[4] = (8.222 + 6.084) * cfaixa;
      System.out.println("Faixa entre 15m³ e 20m³    " + cfaixa + "      R$" + vet[4]);
      return 0;
    }
  }
  
  static double faixa6(double consumo, double vet[]) {
    double cfaixa = consumo - 20;
    if (consumo > 20) {
      faixa5(20, vet);
      vet[5] = (10.458 + 7.739) * cfaixa;
      System.out.println("Faixa entre 20m³ e 40m³    " + cfaixa + "     R$" + vet[5]);
      return 0;
    } else {
      faixa5(consumo, vet);
      cfaixa = 0;
      vet[5] = (10.458 + 7.739) * cfaixa;
      System.out.println("Faixa entre 20m³ e 40m³     " + cfaixa + "      R$" + vet[5]);
      return 0;
    }
  }
  
  static double faixa7(double consumo, double vet[])
  {
    double cfaixa = consumo - 40;
    if (consumo > 40) {
      faixa6(40, vet);
      vet[6] = (12.759 + 9.441) * cfaixa;
      System.out.println("Faixa acima de 40m³      " + cfaixa + "     R$" + vet[6]);
      return 0;
    } else {
      faixa6(consumo, vet);
      cfaixa = 0;
      vet[6] = (12.759 + 9.441) * cfaixa;
      System.out.println("Faixa acima de 40m³      " + cfaixa + "     R$" + vet[6]);
      return 0;
    }
  }
  static double valorDaConta(double vet[]) 
  {
    double soma = 0;
    for (int c = 0; c < 7; c++) {
      soma += vet[c];
    }
    return soma;
  }
  public static void main(String[] args) {
    double vet[] = new double[7];//declara o vetor que armazenará os valores em cada faixa
    double consumo;//declara o consumo em metros cúbicos
    double valor;
    System.out.println("Informe o consumo em m³:");
    consumo = MyIO.readDouble();
  
    if (consumo < 0) // caso seja informado consumo abaixo de zero,retornar erro
                    
    {
      System.out.println("valor informado incorretamente");
    } else {
      faixa7(consumo, vet);
    }
    valor = valorDaConta(vet);
    System.out.println("Valor a pagar nesta fatura: R$" + valor);
  }
}