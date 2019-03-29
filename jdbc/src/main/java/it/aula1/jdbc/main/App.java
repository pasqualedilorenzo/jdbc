package it.aula1.jdbc.main;

import it.aula1.jdbc.dao.EmployeeDAO;
import it.aula1.jdbc.dao.EmployeeDAOImpl;

/**
 * Hello world!
 */
public final class App {

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
    	
        System.out.println("Hello World!");
        EmployeeDAO emp = new EmployeeDAOImpl();
        //TODO COMMENTARE UNA VOLTA CREATA LA STRUTTURA
        //emp.initEmployee();
        emp.addEmployee(2, "TERESA", 100000);
        System.out.println(emp.list());
    }
}
