package org.operations;

import org.DataSource;
import org.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OutputCurrentUsers implements Operation {

    public List<User> getAll() throws SQLException {
        String SQL_QUERY = "select * from user";
        List<User> users;

        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
             ResultSet rs = pst.executeQuery()) {
            users = new ArrayList<>();
            User user;
            while ( rs.next() ) {
                user = new User();
                user.setId( rs.getInt( "id" ) );
                user.setName( rs.getString( "name" ) );
                user.setInfo( rs.getString( "info" ) );
                users.add( user );
            }
        }
        return users;
    }

    @Override
    public void execute() throws SQLException {
        getAll().forEach(user -> System.out.println(user.toString()));
    }
}
