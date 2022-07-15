package org.operations.add_and_delete_ten_random_users;

import org.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserRowWithDelay extends AddUserRow {
    @Override
    public void execute() throws SQLException, InterruptedException {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            Thread.sleep(1000);
            ps.setString(1, name);
            ps.setString(2, info);
            ps.executeUpdate();
            con.close();
        }
    }
}
