package com.dmt.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dmt.model.Contract;
import com.dmt.model.Project;
import com.dmt.model.Role;
import com.dmt.model.Task;
import com.dmt.model.User;

public class TestDB {
	public static void main(String[] args) {
//		User u = new User();
//		u.setTen("qqqq");
//		u.setUsername("QuangN2");
//		u.setTuoi(20);
//		u.setID_Role(0);
//		u.setPass("QQQ");
//		
//		LocalDate localDate = LocalDate.of(2023, 5, 25);
//		Date sqlDate = Date.valueOf(localDate);
//		Contract c = new Contract("Hop dong A", 1,1,sqlDate,sqlDate);
		
		TestDB t = new TestDB();
		try {
			//t.addNewUser(u);
			//t.addContract(c);
			System.out.println(t.IsUser("QuangN2"));
			Task tt = new Task(0, "222", 1, 1, -1);
			t.addTask(tt);
			t.addTask(null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//user
	public void addNewUser(User u) throws Exception {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
		String sql = "INSERT INTO User (Username, Pass, Ten, Tuoi, ID_Role, IsActive) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = connectionDB.cn.prepareStatement(sql);
		cmd.setString(1, u.getUsername());
		cmd.setString(2, u.getPass());
		cmd.setString(3, u.getTen());
		cmd.setDate(4, u.getTuoi());
		cmd.setInt(5, u.getID_Role());
		cmd.setBoolean(6, u.isIsActive());
		cmd.executeUpdate();
		connectionDB.cn.close();
	}
	public void updateUser(User user) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "UPDATE User SET Ten = ?, Username = ?, Pass = ?,  Tuoi = ?, ID_Role = ?, IsActive = ? WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setString(1, user.getTen());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPass());
        statement.setDate(4, user.getTuoi());
        statement.setInt(5, user.getID_Role());
        statement.setBoolean(6, user.isIsActive());
        statement.setInt(7, user.getID());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update user.");
        }
}	
	public User IsUser(String userName) throws SQLException {
		User user = null;
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
		String query = "SELECT * FROM User WHERE Username = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setString(1, userName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String Username = resultSet.getString("Username");
            String Pass = resultSet.getString("Pass");
            String Ten = resultSet.getString("Ten");
            Date Tuoi = resultSet.getDate("Tuoi");
            int ID_Role = resultSet.getInt("ID_Role");
            int ID_Project = resultSet.getInt("ID_Project");
            boolean IsActive = resultSet.getBoolean("IsActive");
            user = new User(ID, Username, Pass, Ten,Tuoi,ID_Role,ID_Project,IsActive);
        }
        return user;
	}
	public User CheckLoginUser(String userName, String password) throws SQLException {
		User user = null;
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
		String query = "SELECT * FROM User WHERE Username = ? and Pass = ?";
		System.out.println(query +","+userName+","+password);
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setString(1, userName);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String Username = resultSet.getString("Username");
            String Pass = resultSet.getString("Pass");
            String Ten = resultSet.getString("Ten");
            Date Tuoi = resultSet.getDate("Tuoi");
            int ID_Role = resultSet.getInt("ID_Role");
            int ID_Project = resultSet.getInt("ID_Project");
            boolean IsActive = resultSet.getBoolean("IsActive");
            user = new User(ID, Username, Pass, Ten,Tuoi,ID_Role,ID_Project,IsActive);
        }
        return user;
	}
	public void removeUser(int userID) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
		String query = "DELETE FROM User WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setInt(1, userID);

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("Failed to remove user.");
        }
}
	public List<User> getAllUsers() throws SQLException {
    	List<User> userList = new ArrayList<>();
    	ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT * FROM User where ID_Role = 3";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date age = resultSet.getDate("Tuoi");
            int role = resultSet.getInt("ID_Role");
            int project = resultSet.getInt("ID_Project");
            boolean isActive = resultSet.getBoolean("IsActive");
            String userName = resultSet.getString("Username");
            String pass = resultSet.getString("Pass");
            User user = new User(ID, userName, pass, name,age, role,project, isActive);
            userList.add(user);
        }
    return userList;
}
	public User getUserByID(int userID) throws SQLException {
    	User user = null;
        ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT * FROM User WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setInt(1, userID);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date age = resultSet.getDate("Tuoi");
            int role = resultSet.getInt("ID_Role");
            int project = resultSet.getInt("ID_Project");
            boolean isActive = resultSet.getBoolean("IsActive");
            String userName = resultSet.getString("Username");
            String pass = resultSet.getString("Pass");
            user = new User(ID, userName, pass, name,age, role,project, isActive);
        }
        return user;
	}
	public List<User> getUserByRole(int userRole) throws SQLException {
		List<User> userList = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT * FROM User WHERE ID_Role = ?";
        System.out.println(query + " " + userRole);
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setInt(1, userRole);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date age = resultSet.getDate("Tuoi");
            int projectID = resultSet.getInt("ID_Project");
            boolean isActive = resultSet.getBoolean("IsActive");
            String userName = resultSet.getString("Username");
            String pass = resultSet.getString("Pass");
            User user = new User(ID, userName, pass, name,age, userRole ,projectID, isActive);
            userList.add(user);
        }
        return userList;
	}
	public List<User> getUserByIDProject(int projectID) throws SQLException {
		List<User> userList = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT * FROM User WHERE ID_Project = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setInt(1, projectID);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date age = resultSet.getDate("Tuoi");
            int role = resultSet.getInt("ID_Role");
            boolean isActive = resultSet.getBoolean("IsActive");
            String userName = resultSet.getString("Username");
            String pass = resultSet.getString("Pass");
            User user = new User(ID, userName, pass, name,age, role,projectID, isActive);
            userList.add(user);
        }
        return userList;
	}
	
	//contract
	public void addContract(Contract c) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
		String sql = "INSERT INTO Contract (Name, ID_Mem, ID_CEO, ThoiHan, NgayKy) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement cmd = connectionDB.cn.prepareStatement(sql);
		cmd.setString(1, c.getName());
		cmd.setInt(2, c.getID_Mem());
		cmd.setInt(3, c.getID_CEO());
		cmd.setInt(4, c.getThoiHan());
		cmd.setDate(5, c.getNgayKy());
		cmd.executeUpdate();
		connectionDB.cn.close();
	}
	public void updateContract(Contract contract) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "UPDATE Contract SET Name = ?, ThoiHan = ? WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setString(1, contract.getName());
        statement.setInt(2, contract.getThoiHan());
        statement.setInt(3, contract.getID());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Contract updated successfully.");
        } else {
            System.out.println("Failed to update contract.");
        }
	}
	public List<Contract> getAllContracts() throws SQLException  {
	        List<Contract> contractList = new ArrayList<>();
	        ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "SELECT * FROM Contract";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                int ID_Mem = resultSet.getInt("ID_Mem");
                int ID_CEO = resultSet.getInt("ID_CEO");
                int ThoiHan = resultSet.getInt("ThoiHan");
                Date NgayKy = resultSet.getDate("NgayKy");
                String nameEmployee = getUserByID(ID_Mem).getTen();
                Contract contract = new Contract(ID, name, ID_Mem, ID_CEO, ThoiHan, NgayKy, nameEmployee);
                contractList.add(contract);
            }
        return contractList;
    }
	public void deleteContract(int contractID) throws SQLException {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "DELETE FROM Contract WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, contractID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contract deleted successfully.");
            } else {
                System.out.println("Failed to delete contract.");
            }
    }
	public  Contract getContractByID(int contractID) throws SQLException{
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
			String query = "SELECT * FROM Contract WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, contractID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                int ID_Mem = resultSet.getInt("ID_Mem");
                int ID_CEO = resultSet.getInt("ID_CEO");
                int ThoiHan = resultSet.getInt("ThoiHan");
                Date NgayKy = resultSet.getDate("NgayKy");

                return new Contract(ID, name, ID_Mem, ID_CEO, ThoiHan, NgayKy);
            }
        return null;
    }
	public  int countContract() throws SQLException{
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "SELECT COUNT(*) AS count FROM Contract";
            int projectCount =0;
            Statement statement = connectionDB.cn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    projectCount = resultSet.getInt("count");
                }
            return projectCount;
            
}
	
	
	//task
	public void addTask(Task task) throws SQLException {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
			String query= "";
			PreparedStatement statement;
			if(task.getUserID() ==-1) {
				query = "INSERT INTO Task (TaskName, Status, ID_Project) VALUES (?, ?, ?)";
				statement = connectionDB.cn.prepareStatement(query);
			}else 
			{
				query = "INSERT INTO Task (TaskName, Status, ID_Project, ID_User) VALUES (?, ?, ?, ?)";
				statement = connectionDB.cn.prepareStatement(query);
	            statement.setInt(4, task.getUserID());
			}
			statement.setString(1, task.getName());
            statement.setInt(2, task.getStatus());
            statement.setInt(3, task.getProjectID());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task inserted successfully.");
            } else {
                System.out.println("Failed to insert task.");
            }
        
    }
	public void deleteTask(int taskID) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "DELETE FROM Task WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setInt(1, taskID);

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Failed to delete task.");
        }
}
	public void updateTask(Task task) throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "UPDATE Task SET TaskName = ?, Status = ?, ID_User = ? WHERE ID = ?";
        PreparedStatement statement = connectionDB.cn.prepareStatement(query);
        statement.setString(1, task.getName());
        statement.setInt(2, task.getStatus());
        statement.setInt(3, task.getUserID());
        statement.setInt(4, task.getID());

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Failed to update task.");
        }
	}
	public Task getTaskByID(int taskID)throws SQLException  {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "SELECT * FROM Task WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, taskID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                int ID_User = resultSet.getInt("ID_User");
                String user = getUserByID(ID_User).getTen();
                return new Task(ID, name, status, projectID, ID_User, user);
            }
        return null;
    }
	public List<Task> getAllTasks()throws SQLException {
	        List<Task> tasks = new ArrayList<>();
	        ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();            
			String query = "SELECT * FROM Task";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                int ID_User = resultSet.getInt("ID_User");

                Task task = new Task(ID, name, status, projectID,ID_User);
                tasks.add(task);
            }
        return tasks;
    }
	public List<Task> getTasksByProjectID(int projectID) throws SQLException{
        List<Task> tasks = new ArrayList<>();
	        ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();    
            String query = "SELECT * FROM Task WHERE ID_Project = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, projectID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int userID = resultSet.getInt("ID_User");
                String nameUser = getUserByID(userID).getTen();
                Task task = new Task(ID, name, status, projectID, userID,nameUser);
                tasks.add(task);
            }
        return tasks;
    }
	public List<Task> getTasksByUserID(int userID) throws SQLException{
        List<Task> tasks = new ArrayList<>();
	        ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();    
            String query = "SELECT * FROM Task WHERE ID_User = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                String nameProject = getProjectByID(projectID).getName();
                Task task = new Task(ID, name, status, projectID, userID,"",nameProject );
                tasks.add(task);
            }
        return tasks;
    }
	public  int countTask() throws SQLException{
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT COUNT(*) AS count FROM Task";
        int Count =0;
        Statement statement = connectionDB.cn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
            	Count = resultSet.getInt("count");
            }
        return Count;
        
	}
	public  int countTaskStatus(int status) throws SQLException{
		/*
		 * ConnectionDB connectionDB = new ConnectionDB(); connectionDB.Connect();
		 * String query = "SELECT COUNT(*) AS count FROM Task where Status = ?"; int
		 * Count = 0; PreparedStatement statement =
		 * connectionDB.cn.prepareStatement(query); statement.setInt(1, status);
		 * ResultSet resultSet = statement.executeQuery(query); if (resultSet.next()) {
		 * Count = resultSet.getInt("count"); } return Count;
		 */
		int count = 0;
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT COUNT(*) AS count FROM Task WHERE Status = ?";
        try (PreparedStatement statement = connectionDB.cn.prepareStatement(query)) {
            statement.setString(1, String.valueOf(status)); // Convert the status to a string

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	count = resultSet.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
        
        
	}
	
	//project
	public void addProject(Project project) throws SQLException {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "INSERT INTO Project (ID, Ten, StartDate, EndDate) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, project.getID());
            statement.setString(2, project.getName());
            statement.setDate(3, project.getStartDate());
            statement.setDate(4, project.getEndDate());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project inserted successfully.");
            } else {
                System.out.println("Failed to insert project.");
            }
    }
	public void updateProject(Project project) throws SQLException {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "UPDATE Project SET Ten = ?, StartDate = ?, EndDate = ? WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setString(1, project.getName());
            statement.setDate(2, project.getStartDate());
            statement.setDate(3, project.getEndDate());
            statement.setInt(4, project.getID());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project updated successfully.");
            } else {
                System.out.println("Failed to update project.");
            }
    }
	public void deleteProject(int projectID) throws SQLException {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "DELETE FROM Project WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, projectID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project deleted successfully.");
            } else {
                System.out.println("Failed to delete project.");
            }
    }
	public Project getProjectByID(int projectID)throws SQLException  {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
			String query = "SELECT * FROM Project WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, projectID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("ten");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");

                return new Project(ID, name, startDate, endDate);
            }
        return null;
    }
	public List<Project> getAllProjects() throws SQLException  {
	        List<Project> projects = new ArrayList<>();
	        ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "SELECT * FROM Project";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Ten");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");

                Project project = new Project(ID, name, startDate, endDate);
                projects.add(project);
            }
        return projects;
    }
	public  int countProject() throws SQLException{
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
        String query = "SELECT COUNT(*) AS count FROM Project";
        int Count =0;
        Statement statement = connectionDB.cn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
            	Count = resultSet.getInt("count");
            }
        return Count;
        
	}
	//role
	public void createRole(Role role)throws SQLException  {
			ConnectionDB connectionDB = new ConnectionDB();
			connectionDB.Connect();
            String query = "INSERT INTO Role (Name) VALUES (?)";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.executeUpdate();
    }
	public Role getRoleByID(int roleID) throws SQLException{
        Role role = null;
        ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
            String query = "SELECT * FROM Role WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, roleID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                role = new Role(ID, name);
            }
        return role;
    }
	public void updateRole(Role role)throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
            String query = "UPDATE Role SET Name = ? WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getID());
            statement.executeUpdate();
    }
	public void deleteRole(int roleID)throws SQLException {
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
            String query = "DELETE FROM Role WHERE ID = ?";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            statement.setInt(1, roleID);
            statement.executeUpdate();
    }
	public List<Role> getAllRoles() throws SQLException{
        List<Role> roles = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.Connect();
            String query = "SELECT * FROM Role";
            PreparedStatement statement = connectionDB.cn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                Role role = new Role(ID, name);
                roles.add(role);
            }
        return roles;
    }

}
