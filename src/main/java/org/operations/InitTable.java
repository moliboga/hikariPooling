package org.operations;

import org.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitTable implements Operation{
    @Override
    public void execute() throws SQLException {
        String sql = "create table if not exists user\n" +
                "(\n" +
                "    id   int auto_increment,\n" +
                "    name varchar(30)  not null,\n" +
                "    info varchar(300) null,\n" +
                "    constraint user_pk\n" +
                "        primary key (id)\n" +
                ");";
        try (
                Connection con = DataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            con.close();
        }
    }
}

