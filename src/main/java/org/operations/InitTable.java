package org.operations;

import org.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitTable implements Operation{
    @Override
    public void execute() throws SQLException {
        String sql = """
                create table if not exists user
                (
                    id   int auto_increment,
                    name varchar(30)  not null,
                    info varchar(300) null,
                    constraint user_pk
                        primary key (id)
                );""";
        try (
                Connection con = DataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("Table created");
            con.close();
        }
    }
}

