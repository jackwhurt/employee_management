package com.kainos.ea.employee_stuff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    private short number;
    private String name;
    private String address;
    private String nin;
    private String bankAccount;
    private int salary;

    private String department;

    @JsonCreator
    public Employee(@JsonProperty("number") short number,@JsonProperty("name") String name,
                    @JsonProperty("address") String address,@JsonProperty("nin") String nin,
                    @JsonProperty("bankAccount")  String bankAccount,@JsonProperty("salary") int salary,
                    @JsonProperty("department")  String department) {
        setNumber(number);
        setName(name);
        setAddress(address);
        setNin(nin);
        setBankAccount(bankAccount);
        setSalary(salary);
        setDepartment(department);
    }

    public Employee(short number, int salary, String name) {
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int calcPay(){
        return getSalary() / 12;
    }

    @Override
    public String toString(){
        String message =
                String.format("Employee %d: %s, ??%,.2f. "
                                ,
                        getNumber(), getName(), (float) getSalary());
        return message;
    }
}
