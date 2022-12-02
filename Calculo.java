//Autor: Pedro Henrique Moreira
//trabalho de calculo sobre consumo de agua em Java.

public class Calculo{
  /*cada funcao criada nessa classe tem como objetivo identificar a faixa de consumo 
informada em metros cubicos pelo usuário e retornar o valor correspondente
*/
  static double func1(double arr[]) 
  {
    double fixaAgua = 17.61; // taxa fixa de água
    double fixaEsgoto = 13.03; // taxa fixa de esgoto
    double fixaTotal = fixaAgua + fixaEsgoto;
    System.out.println(" TAXA FIXA:            de esgoto R$"+ fixaEsgoto +"            de água R$"+ fixaAgua);
    System.out.println("\nFaixa de consumo:     Gasto em m³:         Valor/faixa: \n");
    arr[0] = fixaTotal;                                                             // caso x = 0 retorna a soma dos valores fixos.
    return 0;
  }
  
  static double func2(double consumo, double arr[])    // f(x) = (1.820 + 1.350) * consumo      caso  0 < x <= 5
  {
    if (consumo > 0) {
      func1(arr);
      arr[1] = (1.820 + 1.350) * consumo;
      System.out.println("Faixa entre 0m³ e 5m³      " + consumo + "      R$" + arr[1]);
      return 0;
    } else {
      func1(arr);
      arr[1] = (1.820 + 1.350) * consumo;
      System.out.println("Faixa entre 0m³ e 5m³      " + consumo + "      R$" + arr[1]);
      return 0;
    }
  }
  
  static double func3(double consumo, double arr[]) {      // f(x) = (3.886 + 2.876) * cfaixa         caso 5 < x <= 10
    double cfaixa = consumo - 5;
    if (consumo > 5) {
      func2(5, arr);
      arr[2] = (3.886 + 2.876) * cfaixa;
      System.out.println("Faixa entre 5m³ e 10m³     " + cfaixa + "      R$" + arr[2]);
      return 0;
    } else {
      func2(consumo, arr);
      cfaixa = 0;
      arr[2] = (3.886 + 2.876) * cfaixa;
      System.out.println("Faixa entre 5m³ e 10m³     " + cfaixa + "      R$" + arr[2]);
      return 0;
    }
  }
  
  static double func4(double consumo, double arr[]) {      // f(x) = (6.023 + 4.457) * cfaixa             caso 10 < x <=15
    double cfaixa = consumo - 10;
    if (consumo > 10) {
      func3(10, arr);
      arr[3] = (6.023 + 4.457) * cfaixa;
      System.out.println("Faixa entre 10m³ e 15m³    " + cfaixa + "      R$" + arr[3]);
      return 0;
    } else {
      func3(consumo, arr);
      cfaixa = 0;
      arr[3] = (6.023 + 4.457) * cfaixa;
      System.out.println("Faixa entre 10m³ e 15m³     " + cfaixa + "     R$" + arr[3]);
      return 0;
    }
  }
  
  static double faixa5(double consumo, double arr[]) {        // f(x) = (8.222 + 6.084) * cfaixa          caso 15 < x <= 20
    double cfaixa = consumo - 15;
    if (consumo > 15) {
      func4(15, arr);
      arr[4] = (8.222 + 6.084) * cfaixa;
      System.out.println("Faixa entre 15m³ e 20m³    " + cfaixa + "      R$" + arr[4]);
      return 0;
    } else {
      func4(consumo, arr);
      cfaixa = 0;
      arr[4] = (8.222 + 6.084) * cfaixa;
      System.out.println("Faixa entre 15m³ e 20m³    " + cfaixa + "      R$" + arr[4]);
      return 0;
    }
  }
  
  static double func6(double consumo, double arr[]) {     // f(x) = (10.458 + 7.739) * cfaixa         caso 20 < x <= 40
    double cfaixa = consumo - 20;
    if (consumo > 20) {
      faixa5(20, arr);
      arr[5] = (10.458 + 7.739) * cfaixa;
      System.out.println("Faixa entre 20m³ e 40m³    " + cfaixa + "     R$" + arr[5]);
      return 0;
    } else {
      faixa5(consumo, arr);
      cfaixa = 0;
      arr[5] = (10.458 + 7.739) * cfaixa;
      System.out.println("Faixa entre 20m³ e 40m³     " + cfaixa + "      R$" + arr[5]);
      return 0;
    }
  }
  
  static double func7(double consumo, double arr[])      // f(x) = (12.759 + 9.441) * cfaixa      caso x > 40
  {
    double cfaixa = consumo - 40;
    if (consumo > 40) {
      func6(40, arr);
      arr[6] = (12.759 + 9.441) * cfaixa;
      System.out.println("Faixa acima de 40m³      " + cfaixa + "     R$" + arr[6]);
      return 0;
    } else {
      func6(consumo, arr);
      cfaixa = 0;
      arr[6] = (12.759 + 9.441) * cfaixa;
      System.out.println("Faixa acima de 40m³      " + cfaixa + "     R$" + arr[6]);
      return 0;
    }
  }
  static double valorDaConta(double arr[]) 
  {
    double soma = 0;
    for (int c = 0; c < 7; c++) {
      soma += arr[c];
    }
    return soma;
  }
  public static void main(String[] args) {
    double arr[] = new double[7];   
    double consumo;//declara o consumo em metros cúbicos
    double valor;
    System.out.println("Informe o consumo em m³:");
    consumo = MyIO.readDouble();
  
    if (consumo < 0) // caso seja informado consumo abaixo de zero,retornar erro
                    
    {
      System.out.println("ERRO, valor incorreto");
    } else {
      func7(consumo, arr);
    }
    valor = valorDaConta(arr);
    System.out.println("\nValor a ser pago: R$" + valor);
  }
}
