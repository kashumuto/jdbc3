import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogs {
    private Long userId;
    private Timestamp dateOfAuthorization;
    private Boolean success;
}


//пользователь, время входа, успешность (FAIL, OK)