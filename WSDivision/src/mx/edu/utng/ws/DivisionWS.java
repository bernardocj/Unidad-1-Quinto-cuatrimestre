package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DivisionWS {
private Connection connection;
private Statement statement;
private ResultSet resultSet;
private PreparedStatement ps;
public DivisionWS() {
	conectar();
}
private void conectar(){
	try {
		Class.forName("org.postgresql.Driver");
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/wstest","postgres","12345");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
	e.printStackTrace();
	}
}
public int addDivision(Division division){
	int result=0;
	if(connection!=null){
		try {
			ps=connection.prepareStatement("INSERT INTO division (nombre,abreviatura,activo,unidad_academica) "
					+ " VALUES (?,?,?,?);");
			ps.setString(1, division.getNombre());
			ps.setString(2, division.getAbreviatura());
			ps.setInt(3, division.getActivo());
			ps.setString(4, division.getUnidadAcademica());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return result;
}
public int updateDivision(Division division){
	int result=0;
	if(connection!=null){
		try {
			ps=connection.prepareStatement("UPDATE division  SET nombre= ?,abreviatura= ?,activo= ?,unidad_academica= ? WHERE id= ?;");
				
			ps.setString(1, division.getNombre());
			ps.setString(2, division.getAbreviatura());
			ps.setInt(3, division.getActivo());
			ps.setString(4, division.getUnidadAcademica());
			ps.setInt(5, division.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return result;
}

public int removeDivision(int id){
	int result=0;
	if(connection!=null){
		try {
			ps=connection.prepareStatement("DELETE FROM division WHERE id= ?;");
			ps.setInt(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return result;
}

public Division[] getDivisiones(){
	Division[] result = null;
	List <Division> divisiones=new ArrayList<Division>();
	if(connection!=null){
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM division;");
			while(resultSet.next()){
				Division division=new Division(
						resultSet.getInt("id"),
						resultSet.getString("nombre"),
						resultSet.getString("abreviatura"), 
						resultSet.getInt("activo"), 
						resultSet.getString("unidad_academica"));
				divisiones.add(division);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	result = divisiones.toArray(new Division[divisiones.size()]);
	return result;
}
//
public Division getDivisionbyId(int id){
	Division division=null;
	if(connection!=null){
		try {
			ps=connection.prepareStatement("SELECT * FROM division WHERE id = ?;");
			ps.setInt(1, id);
			resultSet=ps.executeQuery();
			while(resultSet.next()){
				division=new Division(
						resultSet.getInt("id"),
						resultSet.getString("nombre"),
						resultSet.getString("abreviatura"), 
						resultSet.getInt("activo"), 
						resultSet.getString("unidad_academica"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return division;
}


}
