package org.ubaldino.taller.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.ubaldino.taller.app.model.User;

/**
 * @author Ubaldino Zurita
 */
@Repository
public class UserDao extends AbstractDao<User> implements UserDaoInterface {

    @Autowired
    private DataSource dataSource ;
    
    
    public DataSource getDataSource(){
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    /*
    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    */
    
    @Override
    public List<User> list() {
        @SuppressWarnings("JPQLValidation")
        TypedQuery<User> query = this.getSession().createQuery("from User");
        return query.getResultList();
    }
    
    @Override
    public boolean isValidUser(String login, String password) throws SQLException{
        String query = "select count(1) from usuarios where login = ? and password = ?";
        System.out.println(query);
        PreparedStatement pstmt = this.dataSource.getConnection().prepareStatement(query);
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        System.out.println(pstmt.toString());
        ResultSet resultSet = pstmt.executeQuery();
        
        if(resultSet.next())
            return (resultSet.getInt(1) > 0);
        else
            return false;
    }
 
}




	
