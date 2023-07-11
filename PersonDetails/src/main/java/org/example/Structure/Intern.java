package org.example.Structure;

public class Intern extends Person{
    private String startDate;
    private String endDate;
    public Intern(String type,int id, String fname, String lname, int age, double amount,String startDate, String endDate ) {
        super(type,id, fname, lname, age, amount);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String toString() {
        return "fname: "+ getFname()+ "\nlname: " + getLname()+ "\nAge: " + getAge()+"\nAmt: " + getAmount()+ "\ntype: " + getType()+"\nrole: "+ getStartDate() + "\ndept: " + getEndDate() ;
    }
}
