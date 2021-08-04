package dev.experto.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class CreditCardRisk {

    public static final int HIGH = 3;
    public static final int LOW = 2;
    public static final int NORMAL = 1;
    enum RiskLevel{
        HIGH(3),
        LOW(2),
        NORMAL(1);
        int lavel;

        RiskLevel(int level){
            this.lavel = level;
        }
        public static RiskLevel getRiskLevel(int number){
            switch (number) {
                case 3: return HIGH;
                case 2: return LOW;
                case 1:
                default: return NORMAL;
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int risk;
    private Long cardNumber;

    @OneToOne(optional = false)
    private CreditCard creditCard;

    public CreditCardRisk() {
    }

    public CreditCardRisk(CreditCard creditCard, Date date, int risk) {
        this.creditCard = creditCard;
        this.cardNumber = creditCard.getCardNumber();
        this.date = date;
        this.risk = risk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "CreditCardRisk{" +
                "id=" + id +
                "cardNumber=" + cardNumber +
                ", date=" + date +
                ", risk=" + RiskLevel.getRiskLevel(risk) +
                '}';
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}