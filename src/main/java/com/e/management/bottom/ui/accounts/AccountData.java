package com.e.management.bottom.ui.accounts;

public class AccountData {

    private String name;
    private int balance;
    private boolean posNeg;
    private int inflow;
    private int outflow;
    private int openingBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isPosNeg() {
        return posNeg;
    }

    public void setPosNeg(boolean posNeg) {
        this.posNeg = posNeg;
    }

    public int getInflow() {
        return inflow;
    }

    public void setInflow(int inflow) {
        this.inflow = inflow;
    }

    public int getOutflow() {
        return outflow;
    }

    public void setOutflow(int outflow) {
        this.outflow = outflow;
    }

    public int getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(int openingBalance) {
        this.openingBalance = openingBalance;
    }
}
