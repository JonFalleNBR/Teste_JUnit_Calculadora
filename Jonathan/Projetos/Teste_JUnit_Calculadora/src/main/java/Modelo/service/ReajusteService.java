package Modelo.service;

import Modelo.Desempenho;
import Modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {


    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal percentual = desempenho.percetualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}
