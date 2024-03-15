package com.example.financeanalyzer;

import java.sql.Connection;
import java.sql.SQLException;

public class ReceiptDaoImplementation implements ReceiptDao{

    static Connection con = DatabaseConnection.getConnection();
    @Override
    public int add(Receipt receipt) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Receipt receipt) throws SQLException {
        // update database
    }
}
