package dev.experto.demo.step.writer;

import dev.experto.demo.domain.CreditCardRisk;
import dev.experto.demo.repository.CreditCardRiskRespository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CreditCardItemWriter implements ItemWriter<CreditCardRisk> {

    @Autowired
    private CreditCardRiskRespository respository;

    @Override
    public void write(List<? extends CreditCardRisk> list) throws Exception {
        respository.saveAll(list);
    }
}
