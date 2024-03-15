package com.example.financeanalyzer;


import java.sql.SQLException;

//This class is based on Singleton Design Pattern to create a tool class to handle all the Receipts
public class FinanceService {

    //static variable reference  of a singleton instance
    private static FinanceService financeService_instance = null;

    //constructor, private constructor to restrict only one instance
    private FinanceService()
    {

    }

    //expose method to update receipt, include receipt data category(Sprint 2: FR8 User can set data category #11)
    public void updateReceipt(Receipt receipt) throws SQLException {
        ReceiptDaoImplementation receiptDao = new ReceiptDaoImplementation();

        receiptDao.update(receipt);
    }



    //expose method to generate finance report

    //static method exposed to create a single instance of Singleton class
    public static synchronized FinanceService getInstance()
    {
        if(financeService_instance == null)
            financeService_instance = new FinanceService();

        return financeService_instance;
    }

}
