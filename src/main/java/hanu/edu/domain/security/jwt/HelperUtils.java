package hanu.edu.domain.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class HelperUtils {
    // Create a JSON object that is readable by the JWT library.
    public static final ObjectWriter JSON_WRITER = new ObjectMapper().writer().withDefaultPrettyPrinter();
}
