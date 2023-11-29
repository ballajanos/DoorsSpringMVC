package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoorsDao {

	public Doors getById(int id) throws SQLException, ClassNotFoundException {
		Connection con=DBHelper.getConnection();
		String query="Select * from doors where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Doors d =new Doors(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate"));	
			DBHelper.closeConnection();
			return d;
		}
		DBHelper.closeConnection();
		return null;
	}
	
	public ArrayList<Doors> getAllDoors() throws SQLException {
		Connection con=DBHelper.getConnection();
		String query="select * from doors";
		PreparedStatement ps=con.prepareStatement(query);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<Doors> doors=new ArrayList<>();
		
		while(rs.next()) {
			Doors d = new Doors(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate"));
			doors.add(d);
		}
		con.close();
		return doors;
	}
	
	public void insertDoor(Doors doorParam) throws SQLException, IOException {
		Connection con=DBHelper.getConnection();
		String query="insert into doors (material, height, width, installationDate) values (?,?,?,?)";
		PreparedStatement prepStmt=con.prepareStatement(query);
		prepStmt.setString(1, doorParam.getMaterial());
		prepStmt.setDouble(2, doorParam.getHeight());
		prepStmt.setDouble(3, doorParam.getWidth());
		prepStmt.setDate(4, (Date) doorParam.getInstallationDate());
		prepStmt.executeUpdate();
	}
}
