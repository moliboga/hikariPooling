package org.operations.add_and_delete_ten_random_users;

import org.DataSource;
import org.operations.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class AddAndDeleteTenRandomUsers implements Operation {

    private String generateRandomString(int size){
        byte[] array = new byte[size];
        new Random().nextBytes(array);
        return new String(array).replace('\n', ' ');
    }

    @Override
    public void execute() throws SQLException, InterruptedException {
        AddUserRow addUserRow = new AddUserRow();
        for (int i = 0; i < 10; i++){
            String name = generateRandomString(7);
            String info = generateRandomString(20);
            addUserRow.setName(name).setInfo(info).execute();
        }

        Operation deleteLastUserRow = new DeleteLastUserRow();
        for (int i = 0; i < 10; i++){
            deleteLastUserRow.execute();
        }
    }
}
