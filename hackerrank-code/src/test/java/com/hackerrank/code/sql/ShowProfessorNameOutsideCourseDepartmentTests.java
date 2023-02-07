package com.hackerrank.code.sql;

import org.junit.jupiter.api.Test;

public class ShowProfessorNameOutsideCourseDepartmentTests {
    
    @Test
    void testShowProfessorNameOutsideCourseDepartment() {
        // we have 4 tables: professor, course, department, and schedule
        // professor has id, name, department_id, salary
        // department has id, name
        // course has id, name, department_id, credits
        // schedule has course_id, professor_id, semester, year

        // write a query to return a list of professor names and their courses for all courses outside of their departments. There should be no duplicate rows, but they can be in any order.
        // the output should be: professor_name, course_name

        // result should unique professor names and their courses for all courses outside of their departments

        // select distinct p.name, c.name from professor p
        // join course c on p.department_id != c.department_id
        // join schedule s on s.course_id = c.id and s.professor_id = p.id
        // order by p.name, c.name;
    }
    
}
