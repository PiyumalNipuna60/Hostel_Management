package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

public interface UserBO extends SuperBO {
    public boolean updateUser(UserDTO userDTO) throws Exception;
    public UserDTO searchUser(String id) throws Exception;
    public String searchUserId(String userName ,String password) throws Exception;
}
