package System;

public class AccountList {
    private String AcNo, email,Title,Current_Balance,Available_Balance,Opening_date,
            Last_Trans,Deposit,withdraw,CardNumber,ACstatus;

    public AccountList(String acNo, String email, String title, String current_Balance, String available_Balance, String opening_date, String last_Trans, String deposit, String withdraw, String cardNumber, String ACstatus) {
        AcNo = acNo;
        this.email = email;
        Title = title;
        Current_Balance = current_Balance;
        Available_Balance = available_Balance;
        Opening_date = opening_date;
        Last_Trans = last_Trans;
        Deposit = deposit;
        this.withdraw = withdraw;
        CardNumber = cardNumber;
        this.ACstatus = ACstatus;
    }

    public String getAcNo() {
        return AcNo;
    }

    public void setAcNo(String acNo) {
        AcNo = acNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCurrent_Balance() {
        return Current_Balance;
    }

    public void setCurrent_Balance(String current_Balance) {
        Current_Balance = current_Balance;
    }

    public String getAvailable_Balance() {
        return Available_Balance;
    }

    public void setAvailable_Balance(String available_Balance) {
        Available_Balance = available_Balance;
    }

    public String getOpening_date() {
        return Opening_date;
    }

    public void setOpening_date(String opening_date) {
        Opening_date = opening_date;
    }

    public String getLast_Trans() {
        return Last_Trans;
    }

    public void setLast_Trans(String last_Trans) {
        Last_Trans = last_Trans;
    }

    public String getDeposit() {
        return Deposit;
    }

    public void setDeposit(String deposit) {
        Deposit = deposit;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getACstatus() {
        return ACstatus;
    }

    public void setACstatus(String ACstatus) {
        this.ACstatus = ACstatus;
    }
}
