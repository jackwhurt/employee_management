package com.kainos.ea.resources;

import com.kainos.ea.database.DatabaseEmployee;
import com.kainos.ea.database.HighestSalesEmployee;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @GET
    @Path("/getHighestSales")
    @Produces(MediaType.APPLICATION_JSON)
    public SalesEmployee getHighestSalesEmployees() {

        return HighestSalesEmployee.getHighestSalesEmployee ();

    }


}
