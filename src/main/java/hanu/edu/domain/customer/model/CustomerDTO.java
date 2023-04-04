package hanu.edu.domain.customer.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private long id;
    @NotNull(message = "Username can't be null")
    private String username;
    @NotEmpty
    @Email(message = "Invalid email.")
    private String email;
    @Length(min = 6, message = "Password should contains at least 6 characters.")
    private String password;
    @NotNull(message = "Address can't be null")
    private String address;
    private String avatar;

    @Pattern(regexp = "[0-9]{10}", message = "Invalid phone number.")
    private String phone;

    public String setPassword(String password) {
        return this.password;
    }


}
