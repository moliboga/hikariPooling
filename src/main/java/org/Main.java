package org;

import org.operations.InsertThreeInitValues;
import org.operations.add_and_delete_ten_random_users.AddAndDeleteTenRandomUsers;
import org.operations.InitTable;
import org.operations.Operation;
import org.operations.OutputCurrentUsers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        List<Operation> operations = new ArrayList<>();
        operations.add(new InitTable());
        operations.add(new InsertThreeInitValues());
        operations.add(new AddAndDeleteTenRandomUsers());
        operations.add(new InsertThreeInitValues());
        operations.add(new OutputCurrentUsers());

        for (Operation op : operations){
            op.execute();
        }
    }
}