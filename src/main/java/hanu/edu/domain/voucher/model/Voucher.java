package hanu.edu.domain.voucher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voucher {
    private long id;
    private long customerId;
    private String title;
    private double rate;
    private Date dueDate;

    public Voucher(long customerId, String title, double rate, Date dueDate) {
        this.customerId = customerId;
        this.title = title;
        this.rate = rate;
        this.dueDate = dueDate;
    }
}
