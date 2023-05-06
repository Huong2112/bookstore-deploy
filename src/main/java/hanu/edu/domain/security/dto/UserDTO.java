package hanu.edu.domain.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Request
public class UserDTO {
    @NotNull
    @Length(min = 6, message = "Username must be at least 6 characters.")
    private String username;
    @NotNull
    @Length(min = 6, message = "Password must be at least 6 characters.")
    private String password;
    @Email(message = "Invalid email!")
    @NotNull
    private String email;

    /**
     * The method is used to validate the user's credentials
     */
    public String checkProperties() throws IllegalAccessException {
        for (Field f : getClass().getFields()) {
            // if any of the field are null
            //      throw an IllegalAccessException.
            // else got the value of field matched
            if (f.get(this) == null) {
                // value of one field is null (not set yet)!
                String[] arr = f.toString().split("\\."); // ~ path
                String t = arr[arr.length - 1];
                // try to find the field name
                if (t.equalsIgnoreCase("username")
                        || t.equalsIgnoreCase("password")
                        || t.equalsIgnoreCase("email")) {
                    // return the missing field
                    return t;
                }
            }
        }
        return null;
    }
}
