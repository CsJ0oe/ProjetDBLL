package tn.dbll.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Job {

    private int id;
    private String name;
    private String location;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean create(String name, String location) {
        try {
            String query = "INSERT INTO JOB (name, location) VALUES (?,?)";
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, location);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            this.id = generatedKeys.getInt(1);
            this.name = name;
            this.location = location;
            statement.close();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean read(int id) {
        try {
            String query = "SELECT * FROM JOB WHERE id = ?";
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            this.id = id;
            this.name = rs.getString("name");
            this.location = rs.getString("location");
            statement.close();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(String name, String location) {
        try {
            String query = "UPDATE JOB SET name = ?, location = ? WHERE id = ?";
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setInt(3, this.id);
            statement.executeUpdate();
            this.name = name;
            this.location = location;
            statement.close();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete() {
        try {
            String query = "DELETE FROM JOB WHERE id = ?";
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            id = 0;
            name = null;
            location = null;
            statement.close();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean Init() {
        try {
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.execute("DROP TABLE IF EXISTS JOB");
            stmt.execute("CREATE TABLE JOB(id int auto_increment primary key, name varchar(255), location varchar(255))");
            stmt.execute("INSERT INTO JOB(name, location) VALUES('Anju' , 'loc1')");
            stmt.execute("INSERT INTO JOB(name, location) VALUES('Sonia', 'loc2')");
            stmt.execute("INSERT INTO JOB(name, location) VALUES('Asha' , 'loc3')");
            stmt.close();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static String toJSON(int id, String name, String location) {
        return "{ \"id\":\"" + id + "\", \"name\":\"" + name + "\", \"location\":\"" + location + "\" }";
    }

    public static String getJobList() {
        try {
            String query = "SELECT * FROM JOB";
            Connection connection = H2DB.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            String result = "[ ";
            boolean first = true;
            while (rs.next()) {
                if (first != true) {
                    result += ", ";
                } else {
                    first = false;
                }
                result += Job.toJSON(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
            }
            result += " ]";
            statement.close();
            connection.commit();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String toString() {
        return toJSON(id, name, location);
    }

}
