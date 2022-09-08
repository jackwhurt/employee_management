package com.kainos.ea.database;

import com.kainos.ea.employee_stuff.Employee;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface DAO {

    @SqlQuery("select * from Employee_JackH where EmployeeID = :id")
    List<Employee> findNameAllEmployees(@Bind("id") int id);

}
