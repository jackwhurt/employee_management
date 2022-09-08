package com.kainos.ea.employee_stuff;

public class SalesEmployee {

    private String name;
    private short number;
    private int salesTotal;

    private float commission;

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

    public void setCommission(float commission){
        this.commission = commission;
    }

    public float getCommission(){
        return commission;
    }

    public SalesEmployee()
    {

    }

    public SalesEmployee(short number, String name, float commission, int salesTotal) {
        setNumber(number);
        setName(name);
        setCommission(commission);
        setSalesTotal(salesTotal);
    }

}
