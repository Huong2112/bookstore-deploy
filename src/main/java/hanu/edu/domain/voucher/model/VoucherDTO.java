package hanu.edu.domain.voucher.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VoucherDTO {
    @NotNull(message = "Name can't be null")
    private String title;
    @NotNull(message = "Description can't be null")
    @Min(value = 0, message = "Invalid value")
    private double rate;
    private Date dueDate;
}
