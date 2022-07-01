package bo.custom.impl;

import bo.custom.UserBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUser_name(), dto.getPassword()));
    }

    @Override
    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = userDAO.getAll();
        List<UserDTO> dtoList= new ArrayList<>();
        for (User user : userList) {
            dtoList.add(new UserDTO(user.getUser_name(), user.getPassword()));
        }
        return dtoList;
    }

    @Override
    public boolean deleteUser(String userNme) throws SQLException, ClassNotFoundException {
        return userDAO.delete(userNme);
    }

    @Override
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUser_name(), dto.getPassword()));
    }

    @Override
    public boolean changeUName(UserDTO dto) throws SQLException, ClassNotFoundException {
        String curntUName = dto.getUser_name();
        String pwd = dto.getPassword();
        String newUName = dto.getNewUnamePwd();

        return userDAO.updateUname(new User(newUName,pwd));
    }

    @Override
    public boolean changePwd(UserDTO dto) throws SQLException, ClassNotFoundException {
        String uName = dto.getUser_name();
        String crntPwd = dto.getPassword();
        String newPwd = dto.getNewUnamePwd();

        return userDAO.update(new User(uName,newPwd));
    }
}
