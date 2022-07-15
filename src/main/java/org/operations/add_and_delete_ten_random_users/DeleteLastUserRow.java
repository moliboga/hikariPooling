package org.operations.add_and_delete_ten_random_users;

import org.DataSource;
import org.operations.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteLastUserRow implements Operation {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DataSource.getConnection();
                Statement ps = conn.createStatement()) {
            ps.executeUpdate("delete from user order by id desc limit 1");
            conn.close();
        }
    }
}
