package com.kainos.ea.resources;

import com.kainos.ea.database.DatabaseEmployee;
import com.kainos.ea.database.EnterEmployees;
import com.kainos.ea.employee_stuff.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
    @Produces(MediaType.APPLICATION_JSON)
    public void getEmployees(Employee employees) {

        List<Employee> emps = new ArrayList<>();
        emps.add(employees);
        EnterEmployees.enterEmployees(emps);

    }


}
