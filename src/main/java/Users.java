import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Long id;
    private String login;
    private String email;
    private String password;
    private Timestamp dateOfRegistration;
}

//ID, Login, email, password, date_of_registration