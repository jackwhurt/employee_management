package com.kainos.ea.employee_stuff;

public class SalesEmployee {

    private String name;
    private short number;
    private int salesTotal;

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalesTotal(int salesTotal){
        this.salesTotal = salesTotal;
    }

    public int getSalesTotal(){
        return salesTotal;
    }

    public SalesEmployee()
    {
    }
    public SalesEmployee(short number, String name, int salesTotal) {
        setNumber(number);
        setName(name);
        setSalesTotal(salesTotal);
    }

}
