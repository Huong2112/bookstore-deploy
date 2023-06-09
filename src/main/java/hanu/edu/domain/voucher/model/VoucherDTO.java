package hanu.edu.domain.voucher.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VoucherDTO {
    private long customerId;
    @NotNull(message = "Name can't be null")
    private String title;
    @Min(value = 0, message = "Invalid value")
    private double rate;
    private Date dueDate;
}
