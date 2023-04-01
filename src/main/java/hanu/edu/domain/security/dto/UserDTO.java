package hanu.edu.domain.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String email;

    public String checkProperties() throws IllegalAccessException {
        for (Field f : getClass().getFields()) {
            if (f.get(this) == null) {
                String[] arr = f.toString().split("\\.");
                String t = arr[arr.length - 1];
                if (t.equalsIgnoreCase("username")
                        || t.equalsIgnoreCase("password")
                        || t.equalsIgnoreCase("email")) {
                    return t;
                }
            }
        }
        return null;
    }

}
