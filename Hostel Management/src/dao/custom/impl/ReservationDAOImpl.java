package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean add(Reservation entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Reservation SET status = : status WHERE res_id = :res_id";
        Query query = session.createQuery(hql);

        query.setParameter("status", entity.getStatus());
        query.setParameter("res_id", entity.getRes_id());


        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = " DELETE FROM Reservation WHERE res_id = :search_id";
        Query query = session.createQuery(hql);
        query.setParameter("search_id", s);
        int rowCount = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }

    @Override
    public Reservation find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Reservation ";
        Query query = session.createQuery(hql);
        List<Reservation> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String generateNewId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT res_id FROM Reservation ORDER BY res_id DESC";
        Query query = session.createQuery(hql);
        List<String> idList = query.list();
        String id = null;

        for (String ids : idList
        ) {
            id = ids;
            System.out.println("IDG"+id);
            break;
        }

        transaction.commit();
        session.close();

        String newVersion;
        if (id.equals(null)) {
            return "RE001";

        } else {
            int i = (Integer.parseInt(id.substring(2)) + 1);

            if (i >= 10) {
                newVersion = "RE0" + i;
            } else {
                newVersion = "RE00" + i;
            }
            System.out.println(newVersion);
            return newVersion;
        }


    }
}
