package ifpr.pgua.eic.tads.banco.controle;

import java.util.ArrayList;

import ifpr.pgua.eic.tads.banco.entidades.ContaBancaria;
import ifpr.pgua.eic.tads.banco.entidades.Pessoa;

public class Banco {
    
    private ArrayList<ContaBancaria> contas;
    private ArrayList<Pessoa> clientes;

    private String nome;


    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    /*public void criarCliente(Pessoa cliente){
        clientes.add(cliente);
    }*/

    public void criarCliente(String nome, 
                             String cpf,
                             int idade,
                            double salario){
        Pessoa pessoa = new Pessoa(nome, cpf, idade, salario);
        clientes.add(pessoa);
    }

    public Pessoa buscarCliente(String cpf){
        /*for(int i=0;i<clientes.size();i++){
            Pessoa cliente = clientes.get(i);
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;*/
        
        for(Pessoa cliente:clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public String listarClientes(){
        String texto="";

        for(Pessoa cliente:clientes){
            texto+=cliente.toString();
        }
        return texto;
    }

    public void criarConta(ContaBancaria conta){
        contas.add(conta);
    }

    public String sacar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.sacar(valor);
            }
        }

        return "Conta não encontrada!!";

    }

    public String depositar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.depositar(valor);
            }
        }

        return "Conta não encontrada!!";

    }

    public String relatorio(){
        String relatorio="";

        for(ContaBancaria aux:contas){
            relatorio=aux.gerarExtrato()+"\n";
        }

        return relatorio;

    }



}