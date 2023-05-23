package ifpr.pgua.eic.tads.banco.entidades;

public class Pessoa {
    
    private String nome;
    private String cpf;
    private int idade;
    private double salario;

    public Pessoa(String nome, String cpf, int idade, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Nome:"+nome+
        " Cpf:" +cpf+
        " Idade:"+idade+
        " Salário: "+salario;

    }

    

}