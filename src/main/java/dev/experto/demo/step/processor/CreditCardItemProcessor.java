package dev.experto.demo.step.processor;

import dev.experto.demo.domain.CreditCard;
import dev.experto.demo.domain.CreditCardRisk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
@Component
public class CreditCardItemProcessor implements ItemProcessor<CreditCard, CreditCardRisk> {

    @Override
    public CreditCardRisk process(CreditCard item) {

        LocalDate today = LocalDate.now();
        LocalDate lastDate = item.getLastPay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long daysBetween = DAYS.between(lastDate, today);
        int risk;
        if (daysBetween >= 20) {
            risk = CreditCardRisk.HIGH;
        } else if (daysBetween > 10) {
            risk = CreditCardRisk.LOW;;
        }else {
            risk = CreditCardRisk.NORMAL;;
        }

        CreditCardRisk creditCardRisk = new CreditCardRisk(item, new Date(), risk);
        return creditCardRisk;
    }
}
