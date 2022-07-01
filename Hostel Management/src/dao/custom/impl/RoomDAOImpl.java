package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Room";
        List<Room> roomList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return roomList;
    }

    @Override
    public boolean save(Room entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Room> search(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Room WHERE room_type_id = :roomId";
        Query query = session.createQuery(hql);
        query.setParameter("roomId", id);
        List<Room> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String typeId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class, typeId);
        session.delete(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Room> generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getRoomTypes() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT type FROM Room";
        List<String> typeList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return typeList;
    }

    @Override
    public List<Room> getRoomId(String type) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Room WHERE type = :roomType";
        Query query = session.createQuery(hql);
        query.setParameter("roomType", type);
        List<Room> id = query.list();

        transaction.commit();
        session.close();
        return id;
    }


}
