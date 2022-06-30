package bo.custom.impl;


import bo.custom.UserBO;
import dao.DAOFactory;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;

public class UserBOImpl implements UserBO {
    private final UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(userDTO.getId(),userDTO.getUserName(),userDTO.getPassword()));
    }

    @Override
    public UserDTO searchUser(String id) throws Exception {
        return null;
    }

    @Override
    public String searchUserId(String userName, String password) throws Exception {
        return userDAO.find(userName , password);
    }
}
