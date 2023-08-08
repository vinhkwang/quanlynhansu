package com.dmt.dao;

import java.sql.*;
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
			int cout = t.countTaskByIdUser(1);
			//t.addNewUser(u);
			//t.addContract(c);
			System.out.println("quang " + cout);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}

    private static final Connection conn = MySQLConnection.getMySQLConnection();
	public static int countProjectByIdUser(int id) throws SQLException{
        String query = "SELECT count(distinct p.ID)  as count from user u inner join task t on u.ID = t.ID_User inner join project p on t.ID_Project = p.ID where u.ID = "+id;
        int Count =0;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
            	Count = resultSet.getInt("count");
            }
        return Count;
        
	}
	public static int countTaskByIdUser(int id) throws SQLException{
        //String query = "SELECT COUNT(*) AS count FROM Project";
        String query = "SELECT COUNT(*) AS count from user u inner join task t on u.ID = t.ID_User inner join project p on t.ID_Project = p.ID where u.ID = " + id;
        System.out.println(query);
        int Count = 0;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
        	Count = resultSet.getInt("count");
        }
        return Count;
	}
	public static int countUserByIdProject(int id) throws SQLException{
        //String query = "SELECT COUNT(*) AS count FROM Project";
        String query = "SELECT count(distinct u.ID)  as count from user u inner join task t on u.ID = t.ID_User inner join project p on t.ID_Project = p.ID where t.ID_Project = " + id;
        System.out.println(query);
        int Count = 0;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
        	Count = resultSet.getInt("count");
        }
        return Count;
	}
	//user
 		public static void addNewUser(User u) throws Exception {
		String sql = "INSERT INTO User (Username, Pass, Ten, Tuoi, ID_Role, IsActive) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = conn.prepareStatement(sql);
		cmd.setString(1, u.getUsername());
		cmd.setString(2, u.getPass());
		cmd.setString(3, u.getTen());
		cmd.setDate(4, u.getTuoi());
		cmd.setInt(5, u.getID_Role());
		cmd.setBoolean(6, u.isIsActive());
		cmd.executeUpdate();
	}
	public static void updateUser(User user) throws SQLException {
        String query = "UPDATE User SET Ten = ?, Username = ?, Pass = ?,  Tuoi = ?, ID_Role = ?, IsActive = ? WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static User IsUser(String userName) throws SQLException {
		User user = null;
		String query = "SELECT * FROM User WHERE Username = ?";
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static User CheckLoginUser(String userName, String password) throws SQLException {
		User user = null;
		String query = "SELECT * FROM User WHERE Username = ? and Pass = ?";
		System.out.println(query +","+userName+","+password);
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static void removeUser(int userID) throws SQLException {
		String query = "DELETE FROM User WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, userID);

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("Failed to remove user.");
        }
}
	public static List<User> getAllUsers(int role_input) throws SQLException {
    	List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM User where ID_Role = "+ role_input;
        PreparedStatement statement = conn.prepareStatement(query);
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
            int couttask = countTaskByIdUser(ID);
            int countproject = countProjectByIdUser(ID);
            Contract c = getContractUserID(ID);
            User user = new User(ID, userName, pass, name,age, role,project, isActive,couttask,countproject,c.getNgayKy());
            userList.add(user);
        }
    return userList;
}
	public static User getUserByID(int userID) throws SQLException {
    	User user = null;
        String query = "SELECT * FROM User WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static List<User> getUserByRole(int userRole) throws SQLException {
		List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM User WHERE ID_Role = ?";
        System.out.println(query + " " + userRole);
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static List<User> getUserByIDProject(int projectID) throws SQLException {
		List<User> userList = new ArrayList<>();
        String query = "SELECT *, u.ID  ID_User FROM task t INNER JOIN user u on u.ID = t.ID_User where t.ID_Project = ?";
        query = "select distinct u.id as ID_User, Ten, Tuoi, ID_Role, IsActive, Username, Pass from user u left join task t on u.ID = t.ID_User where t.ID_Project = ?";
        
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, projectID);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	int ID = resultSet.getInt("ID_User");
            String name = resultSet.getString("Ten");
            Date age = resultSet.getDate("Tuoi");
            int role = resultSet.getInt("ID_Role");
            boolean isActive = resultSet.getBoolean("IsActive");
            String userName = resultSet.getString("Username");
            String pass = resultSet.getString("Pass");
            int couttask = countTaskByIdUser(ID);
            int countproject = countProjectByIdUser(ID);
            Contract c = getContractUserID(ID);
            User user = new User(ID, userName, pass, name,age, role,projectID, isActive);
            user.setCountProject(countproject);
            user.setCountTask(couttask);
            user.setNgayKy(c.getNgayKy());
            userList.add(user);
        }
        return userList;
	}
	
	
	//contract
	public static void addContract(Contract c) throws SQLException {
		String sql = "INSERT INTO Contract (Name, ID_Mem, ID_CEO, ThoiHan, NgayKy) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement cmd = conn.prepareStatement(sql);
		cmd.setString(1, c.getName());
		cmd.setInt(2, c.getID_Mem());
		cmd.setInt(3, c.getID_CEO());
		cmd.setInt(4, c.getThoiHan());
		cmd.setDate(5, c.getNgayKy());
		cmd.executeUpdate();
	}
	public static void updateContract(Contract contract) throws SQLException {
        String query = "UPDATE Contract SET Name = ?, ThoiHan = ? WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
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
	public static List<Contract> getAllContracts() throws SQLException  {
	        List<Contract> contractList = new ArrayList<>();
            String query = "SELECT * FROM Contract";
            PreparedStatement statement = conn.prepareStatement(query);

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
	public static List<Contract> getAllContractsSearch(String search) throws SQLException  {
        List<Contract> contractList = new ArrayList<>();
        String query = "SELECT * FROM Contract where ID LIKE '%"+search+"%'";
        PreparedStatement statement = conn.prepareStatement(query);

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
	public static void deleteContract(int contractID) throws SQLException {

            String query = "DELETE FROM Contract WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, contractID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contract deleted successfully.");
            } else {
                System.out.println("Failed to delete contract.");
            }
    }
	public static Contract getContractByID(int contractID) throws SQLException{

			String query = "SELECT * FROM Contract WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
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
	public static Contract getContractUserID(int userID) throws SQLException{

		String query = "SELECT * FROM Contract WHERE ID_Mem = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, userID);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            int ID_CEO = resultSet.getInt("ID_CEO");
            int ThoiHan = resultSet.getInt("ThoiHan");
            Date NgayKy = resultSet.getDate("NgayKy");

            return new Contract(ID, name, userID, ID_CEO, ThoiHan, NgayKy);
        }
    return null;
}
	public static int countContract() throws SQLException{

            String query = "SELECT COUNT(*) AS count FROM Contract";
            int projectCount =0;
            Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    projectCount = resultSet.getInt("count");
                }
            return projectCount;
            
}
	
	
	//task
	public static void addTask(Task task) throws SQLException {

			String query= "";
			PreparedStatement statement;
			if(task.getUserID() ==-1) {
				//trường hợp chưa add user vào làm task
				query = "INSERT INTO Task (TaskName, Status, ID_Project, Description, Evidence, StartDay, EndDay) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = conn.prepareStatement(query);
			}else 
			{
				query = "INSERT INTO Task (TaskName, Status, ID_Project, Description, Evidence, StartDay, EndDay, ID_User) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				statement = conn.prepareStatement(query);
	            statement.setInt(8, task.getUserID());
			}
			statement.setString(1, task.getName());
            statement.setInt(2, task.getStatus());
            statement.setInt(3, task.getProjectID());
            statement.setString(4, task.getDescription());
            statement.setString(5, task.getEvidence());
            statement.setDate(6, task.getStartDay());
            statement.setDate(7, task.getEndDay());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task inserted successfully.");
            } else {
                System.out.println("Failed to insert task.");
            }
        
    }
	public static void deleteTask(int taskID) throws SQLException {

        String query = "DELETE FROM Task WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, taskID);

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Failed to delete task.");
        }
}
	public static void updateTask(Task task) throws SQLException {

        String query = "UPDATE Task SET TaskName = ?, Status = ?, ID_User = ?, Description = ?, Evidence = ?, StartDay =?, EndDay = ? WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, task.getName());
        statement.setInt(2, task.getStatus());
        statement.setInt(3, task.getUserID());
        statement.setString(4, task.getDescription());
        statement.setString(5, task.getEvidence());
        statement.setDate(6, task.getStartDay());
        statement.setDate(7, task.getEndDay());
        statement.setInt(8, task.getID());

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Failed to update task.");
        }
	}
	public static Task getTaskByID(int taskID)throws SQLException  {

            String query = "SELECT * FROM Task WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, taskID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                int ID_User = resultSet.getInt("ID_User");
                Date StartDay = resultSet.getDate("StartDay");
                Date EndDay = resultSet.getDate("EndDay");
                String user = getUserByID(ID_User).getTen();
                String des = resultSet.getString("Description");
                String evi = resultSet.getString("Evidence");
                Task t = new Task(ID, name, status, projectID, ID_User, user, StartDay, EndDay);
                t.setDescription(des);
                t.setEvidence(evi);                
                return t;
            }
        return null;
    }
	public static List<Task> getAllTasks()throws SQLException {
	        List<Task> tasks = new ArrayList<>();

			String query = "SELECT * FROM Task";
            PreparedStatement statement = conn.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                int ID_User = resultSet.getInt("ID_User");
                Date StartDay = resultSet.getDate("StartDay");
                Date EndDay = resultSet.getDate("EndDay");

                Task task = new Task(ID, name, status, projectID,ID_User, StartDay, EndDay);
                tasks.add(task);
            }
        return tasks;
    }
	public  static List<Task> getTasksByProjectID(int projectID) throws SQLException{
        List<Task> tasks = new ArrayList<>();

            String query = "SELECT * FROM Task WHERE ID_Project = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, projectID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                Integer userID = resultSet.getInt("ID_User");
                Date StartDay = resultSet.getDate("StartDay");
                Date EndDay = resultSet.getDate("EndDay");
                String nameUser = userID == 0 ? "Chưa assign" : getUserByID(userID).getTen();
                Task task = new Task(ID, name, status, projectID, userID, nameUser , StartDay, EndDay);
                tasks.add(task);
            }
        return tasks;
    }
	public static List<Task> getTasksByUserID(int userID) throws SQLException{
        List<Task> tasks = new ArrayList<>();

            String query = "SELECT * FROM Task WHERE ID_User = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("TaskName");
                int status = resultSet.getInt("status");
                int projectID = resultSet.getInt("ID_Project");
                Date StartDay = resultSet.getDate("StartDay");
                Date EndDay = resultSet.getDate("EndDay");
                String nameProject = getProjectByID(projectID).getName();
                Task task = new Task(ID, name, status, projectID, userID,"",nameProject ,StartDay,EndDay);
                tasks.add(task);
            }
        return tasks;
    }
	public static int countTask() throws SQLException{

        String query = "SELECT COUNT(*) AS count FROM Task";
        int Count =0;
        Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
            	Count = resultSet.getInt("count");
            }
        return Count;
        
	}
	public static int countTaskStatus(int status) throws SQLException{
		/*
		 * ConnectionDB connectionDB = new ConnectionDB(); connectionDB.Connect();
		 * String query = "SELECT COUNT(*) AS count FROM Task where Status = ?"; int
		 * Count = 0; PreparedStatement statement =
		 * connectionDB.cn.prepareStatement(query); statement.setInt(1, status);
		 * ResultSet resultSet = statement.executeQuery(query); if (resultSet.next()) {
		 * Count = resultSet.getInt("count"); } return Count;
		 */
		int count = 0;

        String query = "SELECT COUNT(*) AS count FROM Task WHERE Status = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
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
	public static void addProject(Project project) throws SQLException {

            String query = "INSERT INTO Project (ID, Ten, StartDate, EndDate, ID_PM, Description) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, project.getID());
            statement.setString(2, project.getName());
            statement.setDate(3, project.getStartDate());
            statement.setDate(4, project.getEndDate());
            statement.setInt(5, project.getID_PM());
            statement.setString(6, project.getDescription());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project inserted successfully.");
            } else {
                System.out.println("Failed to insert project.");
            }
    }
	public static void updateProject(Project project) throws SQLException {

            String query = "UPDATE Project SET Ten = ?, StartDate = ?, EndDate = ?, ID_PM = ?, Description = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, project.getName());
            statement.setDate(2, project.getStartDate());
            statement.setDate(3, project.getEndDate());
            statement.setInt(4, project.getID_PM());
            statement.setString(5, project.getDescription());
            statement.setInt(6, project.getID());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project updated successfully.");
            } else {
                System.out.println("Failed to update project.");
            }
    }
	public static void deleteProject(int projectID) throws SQLException {

            String query = "DELETE FROM Project WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, projectID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project deleted successfully.");
            } else {
                System.out.println("Failed to delete project.");
            }
    }
	public static Project getProjectByID(int projectID)throws SQLException  {

			String query = "SELECT * FROM Project WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, projectID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("ten");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                int ID_PM = resultSet.getInt("ID_PM");
                String Description = resultSet.getString("Description");
                Project project = new Project(ID, name, startDate, endDate,ID_PM,Description, 0, "");
                return project;
            }
        return null;
    }
	public static List<Project> getAllProjects() throws SQLException  {
	        List<Project> projects = new ArrayList<>();

            String query = "SELECT * FROM Project";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Ten");
                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                int ID_PM = resultSet.getInt("ID_PM");
                String Description = resultSet.getString("Description");
                String NamePM = getUserByID(ID_PM).getTen();
                int CountMember = countUserByIdProject(ID);
                Project project = new Project(ID, name, startDate, endDate,ID_PM,Description,CountMember,NamePM);
                projects.add(project);
            }
        return projects;
    }
	public static List<Project> getAllProjectsByUserId(int id) throws SQLException  {
        List<Project> projects = new ArrayList<>();

        String query = "SELECT distinct p.ID, p.Ten, p.StartDate,p.EndDate, p.ID_PM, p.Description FROM task t inner join project p on t.ID_Project = p.ID where t.ID_User = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date startDate = resultSet.getDate("startDate");
            Date endDate = resultSet.getDate("endDate");
            int ID_PM = resultSet.getInt("ID_PM");
            String Description = resultSet.getString("Description");
            String NamePM = getUserByID(ID_PM).getTen();
            int CountMember = countUserByIdProject(ID);
            Project project = new Project(ID, name, startDate, endDate,ID_PM,Description,CountMember,NamePM);
            projects.add(project);
        }
        return projects;
	}
	public static List<Project> getAllProjectsByPMId(int id) throws SQLException  {
        List<Project> projects = new ArrayList<>();

        String query = "SELECT * FROM project where ID_PM = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            Date startDate = resultSet.getDate("startDate");
            Date endDate = resultSet.getDate("endDate");
            int ID_PM = resultSet.getInt("ID_PM");
            String Description = resultSet.getString("Description");
            String NamePM = getUserByID(ID_PM).getTen();
            int CountMember = countUserByIdProject(ID);
            Project project = new Project(ID, name, startDate, endDate,ID_PM,Description,CountMember,NamePM);
            projects.add(project);
        }
        return projects;
	}
	public static int countProject() throws SQLException{

        String query = "SELECT COUNT(*) AS count FROM Project";
        int Count =0;
        Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
            	Count = resultSet.getInt("count");
            }
        return Count;
        
	}
	//role
	public static void createRole(Role role)throws SQLException  {

            String query = "INSERT INTO Role (Name) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.executeUpdate();
    }
	public static Role getRoleByID(int roleID) throws SQLException{
        Role role = null;

            String query = "SELECT * FROM Role WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, roleID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                role = new Role(ID, name);
            }
        return role;
    }
	public static void updateRole(Role role)throws SQLException {

            String query = "UPDATE Role SET Name = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getID());
            statement.executeUpdate();
    }
	public static void deleteRole(int roleID)throws SQLException {

            String query = "DELETE FROM Role WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, roleID);
            statement.executeUpdate();
    }
	public static List<Role> getAllRoles() throws SQLException{
        List<Role> roles = new ArrayList<>();

            String query = "SELECT * FROM Role";
            PreparedStatement statement = conn.prepareStatement(query);
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
