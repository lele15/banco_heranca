package ifpr.pgua.eic.tads.banco.entidades;

public class ContaCorrente extends ContaBancaria {
    
    public ContaCorrente(String agencia, String numero, Pessoa cliente, double saldo, double limite) {
        super(agencia, numero, cliente, saldo);
        this.limite = limite;
    }

    private double limite;

    

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String gerarExtrato(){
        String texto;

        texto = super.gerarExtrato();

        texto += " Limite:"+limite;

        return texto;
    }

    @Override
    public String sacar(double valor){
        if(valor < 0){
            return "Valor inválido!";
            //return false;
        }
        if(valor > saldo + limite){
            return "Saldo insuficiente!";
            //System.out.println("Impossível sacar!!");
            //return false;
        }

        saldo = saldo - valor;
        return "ok";

    }

    @Override
    public String tipo(){
        return "Conta Corrente";
    }


}