package hanu.edu.domain.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Request
public class UserDTO {
    private String username;
    private String password;
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
