package Modelo.service;

import Modelo.Desempenho;
import Modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {


    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
            if(desempenho == Desempenho.A_DESEJAR){
                BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
                funcionario.reajustarSalario(reajuste);
            }
    }
}