package com.project.bills_page;

import java.util.Date;

public class Bill {
    private String billName;
    private String amount;
    private Date dueDate;

    // Private constructor to enforce the use of the builder
    private Bill(String billName, String amount, Date dueDate) {
        this.billName = billName;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // Builder class
    public static class Builder {
        private String billName;
        private String amount;
        private Date dueDate;

        public Builder setBillName(String billName) {
            this.billName = billName;
            return this;
        }

        public Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Bill build() {
            // Validate parameters if necessary
            return new Bill(billName, amount, dueDate);
        }
    }
