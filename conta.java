package thread;

import javax.swing.plaf.TableHeaderUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta implements Runnable{
    private String nome;
    private double saldo;
    private String operacao;
    double valor;

    public Conta(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
        this.operacao = "Consulta";
        double valor;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSaldo(){
        return this.nome;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public String getOperacao(){
        return this.operacao;
    }

    public void setOperacao(String Operacao){
        this.Operacao = operacao;
    }


    void exibirSaldo(){
        Thread consulta = new Thread(this)
        consulta.start();
        Try{
            consulta.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void depositarValor(double valor){
        this.valor = valor;
        this.setOperacao("Deposito");
        Thread deposito = new Thread(this);
        deposito.start();
         Try{
            deposito.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void retirarValor(double valor){
        this.valor = valor * (-1);
        this.setOperacao("Saque");
        Thread saque = new Thread(this);
        saque.start();
         Try{
            saque.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){

    	DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mn:ss:ms");
    	Date data = new Date();
    	System.out.println(dateFormat.format(data));

        Try{
        System.out.println("Titular: "+ this.nome);
        if(this.operacao == "Consulta"){
            double saldo = this.getSaldo();
            System.out.println("Checando seu saldo....");
            Thread.sleep(500);
            System.out.println("Seu saldo atual é de R$"+ saldo);
            System.out.println("-------------------");

        } else if (this.operacao == "Deposito"){
            double saldo = this.getSaldo();
            System.out.println("Realizando depósito....");
            Thread.sleep(500);
            this.setSaldo(this.getSaldo + valor);
            System.out.println("Seu saldo atual é de R$"+ this.saldo);
            System.out.println("-------------------");
        } else if (this.operacao == "Saque"){
            if(saldo > (this.valor * (-1))) {
             double saldo = this.getSaldo();
            System.out.println("Contando cédulas....");
            Thread.sleep(500);
            this.setSaldo(saldo + valor);
            System.out.println("Retire seu dinheiro....");
            System.out.println("Seu saldo atual é de R$"+ this.saldo);
            System.out.println("-------------------");   
            } else {
                System.out.println("Saldo insuficiente...");
                System.out.println("Operação não realizada...");
                System.out.println("Seu saldo atual é de: R$" + this.getSaldo());
                System.out.println("-------------------");
            }
        }
        this.setOperacao("Consulta");
        this.valor = 0;
            } catch (InterruptedExcpetion e){
                e.printStackTrace();
        }



    }

}
