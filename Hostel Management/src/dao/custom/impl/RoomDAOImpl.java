package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Room SET type = :type,key_money = : key_money, qty = : qty  WHERE room_type_id = :room_id";
        Query query = session.createQuery(hql);
        query.setParameter("type", entity.getType());
        query.setParameter("key_money", entity.getKey_money());
        query.setParameter("qty", entity.getQty());
        query.setParameter("room_id", entity.getRoom_type_id());
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean update(String id ,int qty) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Room SET  qty = : qty  WHERE room_type_id = :room_id";
        Query query = session.createQuery(hql);
        query.setParameter("qty", qty);
        query.setParameter("room_id", id);
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String id = s;
        String hql = " DELETE FROM Room WHERE room_type_id = :search_id";
        Query query = session.createQuery(hql);
        query.setParameter("search_id", id);
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public Room find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String id = s;
        String hql = "FROM Room  WHERE room_type_id = :search_id";
        Query query = session.createQuery(hql);
        query.setParameter("search_id", id);
        List<Room> RoomsList = query.list();
        for (Room r :RoomsList ) {
            return new Room(r.getRoom_type_id(),r.getType(),r.getKey_money(),r.getQty());
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<Room> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Room ";
        Query query = session.createQuery(hql);
        List<Room> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<String> getAllRoomIds() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT room_type_id FROM Room ";
        Query query = session.createQuery(hql);
        List<String> idList = query.list();
        transaction.commit();
        session.close();
        return idList;
    }

    @Override
    public boolean addNewRoomType(String id, int qty) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Room SET qty = :qty  WHERE room_type_id = :room_id";
        Query query = session.createQuery(hql);
        query.setParameter("qty", qty);
        query.setParameter("room_id", id);
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }
}

