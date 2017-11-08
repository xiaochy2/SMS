package com.chf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chf.dao.dbhelp.DBUtil;
import com.chf.entity.User;

public class UserDao {

	public int update(User user) {
		StringBuffer sql = new StringBuffer();
		int i = 0;
		try {
			sql.append("UPDATE user SET password='" + user.getPassword() + "',");
            sql.append("role='" + user.getRole() + "',");
            sql.append("roleId='" + user.getRoleId() + "',");
            sql.append("username='" + user.getUserName() + "'");
			sql.append("WHERE id='" + user.getId() + "';");

			i = DBUtil.executeUpdateInsertDelete(sql.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}
	public int delete(User user) {
		StringBuffer sql = new StringBuffer();
        StringBuffer sql1 = new StringBuffer();

		sql.append("delete from user where username='" + user.getUserName() + "';");
        sql1.append("delete from mark where stuName='" + user.getUserName() + "';");

        if(user.getRole()==0){
            return DBUtil.executeUpdateInsertDelete(sql.toString())+DBUtil.executeUpdateInsertDelete(sql1.toString());
        }
        else
        {
            return DBUtil.executeUpdateInsertDelete(sql.toString());
        }
	}
	public int insert(User user) {
		StringBuffer sql = new StringBuffer();
        StringBuffer sql1 = new StringBuffer();

		sql.append("insert into user(username,password,role,roleId)");
		sql.append("values('" + user.getUserName() + "',");
        sql.append("'" + user.getPassword() + "',");
        sql.append("'" + user.getRole() + "',");
		sql.append("'" + user.getRoleId() + "'); ");
        sql1.append("insert into mark(stuId,stuName,English,Math,Physics,state)");
        sql1.append("values('" + user.getRoleId() + "',");
        sql1.append("'" + user.getUserName() + "',");
        sql1.append("'0',");
        sql1.append("'0',");
        sql1.append("'0',");
        sql1.append("'UnMark');");
        if(user.getRole()==0){
          return DBUtil.executeUpdateInsertDelete(sql.toString())+DBUtil.executeUpdateInsertDelete(sql1.toString());
        }
        else
        {
            return DBUtil.executeUpdateInsertDelete(sql.toString());
        }
	}
	public User findByUserName(String userName) {
		User user = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user where username='" + userName + "';");

		try {
			ResultSet set = DBUtil.executeQuery(sql.toString());
			
			while (set.next()) {
				
				user = new User();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));
                user.setRoleId(set.getInt("roleId"));

				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
	public List<User> findByName(String userName){
		List<User> list = new ArrayList<User>();
		
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM user WHERE username = '");
		sql.append(userName);
		sql.append("';");
		
		try{
			ResultSet set=DBUtil.executeQuery(sql.toString());
			while(set.next()){
				User user=new User();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));
                user.setRoleId(set.getInt("roleId"));

				list.add(user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

    public List<User> findUserAll(){
        List<User> list = new ArrayList<User>();

        StringBuffer sql=new StringBuffer();
        sql.append("SELECT * FROM user;");

        try{
            ResultSet set=DBUtil.executeQuery(sql.toString());
            while(set.next()){
                User user=new User();
                user.setId(set.getInt("id"));
                user.setUserName(set.getString("username"));
                user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));
                user.setRoleId(set.getInt("roleId"));

                list.add(user);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
	
}
