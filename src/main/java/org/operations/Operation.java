package org.operations;

import java.sql.SQLException;

public interface Operation {
    void execute() throws SQLException, InterruptedException;
}
