package org.operations.add_and_delete_ten_random_users;

import org.DataSource;
import org.operations.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserRow implements Operation {

    protected String info;
    protected String name;

    protected final String sql = "INSERT INTO user (name, info) VALUES(?, ?)";

    public AddUserRow(){
    }

    public AddUserRow setName(String name){
        this.name = name;
        return this;
    }

    public AddUserRow setInfo(String info){
        this.info = info;
        return this;
    }

    @Override
    public void execute() throws SQLException, InterruptedException {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, info);
            ps.executeUpdate();
            con.close();
        }
    }
}
