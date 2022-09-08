package com.kainos.ea.database;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface DAO {

    @SqlQuery("select * from Employee_JackH where EmployeeID = :id")
    List<Employee> findNameAllEmployees(@Bind("id") int id);

}
