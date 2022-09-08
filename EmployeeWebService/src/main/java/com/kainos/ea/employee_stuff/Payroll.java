package com.kainos.ea.employee_stuff;

public class Payroll {
    private float taxRate = 0.25f;

    public int netPay(Employee payee) {
        int grossPay = payee.calcPay();
        int taxToPay = Math.round(grossPay * taxRate);
        return grossPay - taxToPay;
    }
}
