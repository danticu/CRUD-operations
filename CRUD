                                                              CRUD OPERATIONS 
package product;
import java.sql.*;
 class DBConnection {
	Connection con;
	PreparedStatement ps ;
	ResultSet rs;
	DBConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","Deepu@123");
			System.out.println("connection established");
		}
		catch(Exception e)
		{
		}
		}
		public void insert(int pid, String pname, String pauthor, int pprice) throws Exception
		{
			ps=con.prepareStatement("insert into product(pid,pname,pauthor,pprice)VALUES(?,?,?,?)");
			ps.setInt(1,pid);
			ps.setString(2,pname);
			ps.setString(3,pauthor);
			ps.setInt(4, pprice);
			ps.executeUpdate();
		
	}
		public void update(int pid, String pname, String pauthor, int pprice) throws Exception
		{
			ps=con.prepareStatement("update product set pname=?, pauthor=?, pprice=? where pid=? ");
		ps.setInt(4,pid);
			ps.setString(1,pname);
			ps.setString(2,pauthor);
			ps.setInt(3, pprice);
			ps.executeUpdate();
		
	}
		public void delete(int pid) throws Exception
		{
			ps=con.prepareStatement("delete from product where pid=? ");
			ps.setInt(1,pid);			
			ps.executeUpdate();
		
	}
		public void display() throws Exception
		{
			ps=con.prepareStatement("select * from product");
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.printf("%-20s%5s%20s%20s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		}

	public  void close() throws Exception{
		con.close();
		System.out.println("connection closed");
		

	}

}
-----------------------------------------------------------------------------------------------------


package product;

import java.util.Scanner;

public class ProductCRUD {

	public static void main(String[] args) throws Exception {
		int choice=-1;
		Scanner sc=new Scanner(System.in);
		DBConnection con=new DBConnection();
		do {
			System.out.println("1.insert");
			System.out.println("2. display");
			System.out.println("3. update");
			System.out.println("4. delete");
			System.out.println("0.exit");
			System.out.println("eneter your choice : ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("enter book id: ");
				int pid=sc.nextInt();
				System.out.println("enter book name: ");
				String pname=sc.next();
				System.out.println("enter book author: ");
				String pauthor=sc.next();
				System.out.println("enter book price: ");
				int pprice=sc.nextInt();
				con.insert(pid, pname, pauthor, pprice);
			break;
			case 2:
				con.display();
				break;
			case 3:
				
				System.out.println("enter  book id: ");
				 pid=sc.nextInt();
				System.out.println("enter new book name: ");
				 pname=sc.next();
				System.out.println("enter new  book author: ");
				  pauthor=sc.next();
				System.out.println("enter new book price: ");
				 pprice=sc.nextInt();
				 con.update(pid, pname, pauthor, pprice);
				break;
			case 4:
				System.out.println("enter the id to delete:");
				 pid=sc.nextInt();
				con.delete(pid);
				break;
				
			case 0:
				con.close();
				System.out.println("thanks");
			}
		}
		while(choice!=0);
		

	}

}                                                              
