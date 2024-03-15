package com.example.financeanalyzer;

import java.sql.SQLException;

public interface ReceiptDao {

    public int add(Receipt receipt)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public void update(Receipt receipt)
        throws SQLException;
}
