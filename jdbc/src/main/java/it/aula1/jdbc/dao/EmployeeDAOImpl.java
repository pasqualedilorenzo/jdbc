package it.aula1.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.aula1.jdbc.model.Employee;
import it.aula1.jdbc.util.jdbcUtil;

public class EmployeeDAOImpl extends jdbcUtil implements EmployeeDAO {
	
	/**
	 * Metodo della creazione della sequence per la tabella employee
	 */
	private boolean createSequenceEmployee() {

		String query = "CREATE SEQUENCE SEQ_EMPLOYEE AS BIGINT START WITH 0";
		try (Statement stat = jdbcUtil.getConnection().createStatement()) {

			jdbcUtil.getConnection().setAutoCommit(true);

			return stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Metodo il recupero della sequence seqEmployee
	 */
	/*private int getSeqEmployee() {

		String query = "CREATE SEQUENCE SEQ_EMPLOYEE AS BIGINT START WITH 0";
		try (Statement stat = jdbcUtil.getConnection().createStatement()) {

			jdbcUtil.getConnection().setAutoCommit(true);

			return stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}*/

	/**
	 * Metodo della creazione della tabella employee
	 */
	private boolean createEmployee() {

		String query = "CREATE TABLE EMPLOYEE (ID INT PRIMARY KEY, NAME VARCHAR(50), SALARY INT)";
		try (Statement stat = jdbcUtil.getConnection().createStatement()) {
			return stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * metodo per l'inserimento di un Employee
	 */
	@Override
	public boolean addEmployee(int id, String name, long salary) {

		//String query = "INSERT INTO EMPLOYEE (ID, NAME, SALARY) VALUES ( SELECT NEXT VALUE FOR SEQ_EMPLOYEE, ?, ?)";
		String query = "INSERT INTO EMPLOYEE (ID, NAME, SALARY) VALUES ( ?, ?, ?)";
		try (PreparedStatement ps = jdbcUtil.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setLong(3, salary);

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * metodo per il recupero di una lista di employee
	 */
	@Override
	public List<Employee> list() {
		List<Employee> list = new ArrayList<>();

		String query = "SELECT ID, NAME, SALARY FROM EMPLOYEE";
		try (PreparedStatement ps = jdbcUtil.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			Employee emp;
			while (rs.next()) {

				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getLong("salary"));

				// Aggiungo un elemento alla lista
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean initEmployee() {
		
		boolean result = false;
		
		result = createEmployee();
		//result = createSequenceEmployee();
		
		return result;
	}

}
