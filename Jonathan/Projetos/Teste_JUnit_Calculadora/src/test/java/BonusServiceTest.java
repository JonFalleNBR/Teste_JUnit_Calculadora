import Modelo.service.BonusService;
import Modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void BonusZeroParaSalarioAlto(){
        BonusService bonusService = new BonusService();
//      assertThrows(IllegalArgumentException.class ,
//              () -> bonusService.calcularBonus(new Funcionario("Jonathan", LocalDate.now(), new BigDecimal("25000"))));
// Exemplo de abordagem para casos de erro com uma Exception, acima com um assertThrows e abaixo com um try catch
        try{
            bonusService.calcularBonus(new Funcionario("Jonathan", LocalDate.now(), new BigDecimal("25000")));
            fail("Não dei a Exception");
        }catch (Exception e){
            assertEquals("Funcionario com salario maior do que R$10000 nao pode receber bonus!", e.getMessage());

        }
    }

    @Test
    void BonusDezPorcentoParaSalarioBaixo(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Michael", LocalDate.now(),
                new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void BonusGenerico(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Michael", LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);

    }

}
