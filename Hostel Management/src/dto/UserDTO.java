package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class UserDTO {
    private String user_name;
    private String password;
    private String newUnamePwd;

    public UserDTO(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public UserDTO(String user_name, String password, String newUnamePwd) {
        this.user_name = user_name;
        this.password = password;
        this.newUnamePwd = newUnamePwd;
    }
}
