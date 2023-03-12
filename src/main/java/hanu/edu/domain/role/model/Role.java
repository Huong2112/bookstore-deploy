package hanu.edu.domain.role.model;

import hanu.edu.domain.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Role implements Serializable {
    private long id;
    private String name;
    private List<User> users = new ArrayList<>();
}
