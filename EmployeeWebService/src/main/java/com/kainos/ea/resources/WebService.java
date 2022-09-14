package com.kainos.ea.resources;

import com.kainos.ea.database.*;
import com.kainos.ea.model.City;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class WebService {

    @GET
    @Path("/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {

        List<Employee> emps = DatabaseEmployee.getEmployees();
        return emps;

    }

    @POST
    @Path("/addEmployees")
    @Consumes(MediaType.APPLICATION_JSON)
    public void getEmployees(List<Employee> employees) {

        EnterEmployees.enterEmployees(employees);

    }

    @GET
    @Path("/getEmployeesDepartment/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeeDepartment(@PathParam("msg") String department) {

        List<Employee> emps = DepartmentEmployee.getEmployeeDepartment(department);
        return emps;

    }

    @GET
    @Path("/getFinanceReport")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getFinanceReport() {

        List<String> emps = FinanceReport.getFinanceReport();
        return emps;

    }

    @GET
    @Path("/getHighestSales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesEmployee> getHighestSales() {

        return HighestSalesEmployee.getHighestSalesEmployee ();

    }

    @GET
    @Path("/getCities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities() {

        return GetCities.getCities();

    }


}