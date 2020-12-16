package thread;

public class Principal{

    public static void main(String[] args){
        Conta eu = new Conta("Guilherme", 1000);
        Conta Evertt = new Conta("Evertt", 1000);
        Conta Fidelis = new Conta("Fidelis", 1000);
      /* eu.exibirSaldo(); */
       eu.depositarValor(500);
       Evertt.depositarValor(300);
       Fidelis.retirarValor(500);
       Fidelis.depositarValor(300);
       eu.retirarValor(1500);
       eu.depositarValor(300);
       eu.retirarValor(500);
       eu.depositarValor(300);
       eu.retirarValor(500);
       Fidelis.depositarValor(1300);
       Evertt.retirarValor(250);
    }

}