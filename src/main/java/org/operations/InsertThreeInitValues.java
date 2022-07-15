package org.operations;

import org.DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class InsertThreeInitValues implements Operation{
    @Override
    public void execute() throws SQLException, RuntimeException {
        String sql = "INSERT INTO user (name, info)\n" +
                     "VALUES (?, ?);";
        Map<String, String> initValues = new HashMap<>();
        initValues.put("artem", "trainee javist");
        initValues.put("kosbi", "middle javist");
        initValues.put("kiril", "senior racist");
        try (PreparedStatement ps =
                     DataSource.getConnection().prepareStatement(sql)){
            for (String key : initValues.keySet()){
                ps.setString(1, key);
                ps.setString(2, initValues.get(key));
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("Values inserted");
        }
    }
}
