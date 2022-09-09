package com.kainos.ea.resources;

import com.kainos.ea.database.*;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;

import javax.ws.rs.GET;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kainos.ea.database.DatabaseEmployee;
import com.kainos.ea.employee_stuff.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class WebService {

    private static final ObjectMapper mapper = new ObjectMapper();
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


}
