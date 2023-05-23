package ifpr.pgua.eic.tads.banco;

import ifpr.pgua.eic.tads.banco.entidades.ContaCorrente;
import ifpr.pgua.eic.tads.banco.entidades.ContaPoupanca;
import ifpr.pgua.eic.tads.banco.entidades.Pessoa;

public class AppTest {
    

    public static void main(String[] args) {
        Pessoa ze = new Pessoa("Zé", "0123", 25, 500);
        Pessoa chico = new Pessoa("Chico", "4567", 35, 1000);

        ContaPoupanca poupanca = new ContaPoupanca("123", "009988", 
                                                   chico, 100, 0.05);

        ContaCorrente corrente = new ContaCorrente("123", "1000156", ze, 0, 100);

        System.out.println(poupanca.gerarExtrato());
        System.out.println(corrente.gerarExtrato());
        
        poupanca.setTxRendimento(0.0001);
        corrente.setLimite(1000);


    }
}