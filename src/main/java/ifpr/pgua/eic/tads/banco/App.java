package ifpr.pgua.eic.tads.banco;

import java.util.ArrayList;
import java.util.Scanner;

import ifpr.pgua.eic.tads.banco.controle.Banco;
import ifpr.pgua.eic.tads.banco.entidades.ContaBancaria;
import ifpr.pgua.eic.tads.banco.entidades.ContaCorrente;
import ifpr.pgua.eic.tads.banco.entidades.Pessoa;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static ContaBancaria conta;

    static Banco banco = new Banco("TADSBank");

    static String imprimirMenu(){
        String str="";
        str += "###----###\n";
        str += "1 - Cadastrar conta\n";
        str += "2 - Sacar\n";
        str += "3 - Depositar\n";
        str += "4 - Ver dados\n";
        str += "5 - Cadastrar Cliente\n";
        str += "6 - Buscar Cliente\n";
        str += "7 - Listar Clientes\n";
        str += "0 - Sair\n";
        str += "Digite uma opção:";

        return str;
    }


    static void cadastrarCliente(){
        String nome;
        String cpf;
        int idade;
        double salario;

        System.out.println("Digite o nome do cliente:");
        nome = teclado.nextLine();
        System.out.println("Digite o cpf do cliente:");
        cpf = teclado.nextLine();
        System.out.println("Digite a idade do cliente:");
        idade = teclado.nextInt();
        System.out.println("Digite o salário:");
        salario = teclado.nextDouble();

        banco.criarCliente(nome, cpf, idade, salario);
    }

    static void buscarCliente(){
        String cpf;

        System.out.println("Digite o cpf:");
        cpf = teclado.nextLine();

        Pessoa cliente = banco.buscarCliente(cpf);

        
        if(cliente != null){
            System.out.println(cliente);
        }else{
            System.out.println("Cliente não encontrado!");
        }
    }

    static void listarClientes(){
        System.out.println("####Lista de Clientes####");
        System.out.println(banco.listarClientes());
        System.out.println("######");
    }

    static void criarConta(){
        
        String cpf;
        String numero;
        String agencia;
        double saldoInicial;
        
        System.out.println("Digite o cpf do cliente:");
        cpf = teclado.nextLine();
        System.out.println("Digite o número da conta:");
        numero = teclado.nextLine();
        System.out.println("Digite a agência da conta:");
        agencia = teclado.nextLine();

        Pessoa pessoa = banco.buscarCliente(cpf);
        if(pessoa != null){
            conta = new ContaCorrente(agencia,numero,pessoa,0,0);

            System.out.println("************");
            
            //adicionando um conta na coleção de contas
            banco.criarConta(conta);
    
        }else{
            System.out.println("Cliente não encontrado! Conta não criada!");
        }
        

    }

    static void sacar(){
        double valor;
        String numero;
        String agencia;
        

        System.out.println("Digite o numero da conta:");
        numero = teclado.nextLine();
        
        System.out.println("Digite o numero da agencia:");
        agencia = teclado.nextLine();
        

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();


        System.out.println(banco.sacar(numero, agencia, valor));

        System.out.println("************");
    }

    static void depositar(){
        double valor;
        String numero;
        String agencia;
        

        System.out.println("Digite o numero da conta:");
        numero = teclado.nextLine();
        
        System.out.println("Digite o numero da agencia:");
        agencia = teclado.nextLine();
        

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();

        String retorno = banco.depositar(numero,agencia,valor);
        System.out.println(retorno);
        System.out.println("************");
    }

    static void mostrarDados(){
        
        System.out.println(banco.relatorio());
    }

    public static void main(String[] args) {

        int opcao=0;

        do{
            System.out.println(imprimirMenu());
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch(opcao){
                case 1:
                    criarConta();
                break;
                case 2:
                    sacar();
                    
                break;
                case 3:
                    depositar();
                break;
                case 4:
                    mostrarDados();
                break;
                case 5:
                    cadastrarCliente();
                break;
                case 6:
                    buscarCliente();
                break;
                case 7:
                    listarClientes();
                break;
                default:
                    if(opcao != 0){
                        System.out.println("Opção inválida!!");
                    }
            }
        }while(opcao != 0);
    }
}