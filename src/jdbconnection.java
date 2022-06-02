import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class jdbconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tejas\\Music\\chromedriver_win32\\chromedriver.exe");
		
		
		String host="localhost";
		String port="3306";
		Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt", "root", "root");
		
		Statement s=conn.createStatement();
		ResultSet rs=s.executeQuery("select * from Employeeinfo");
		while(rs.next())              //starting index
		{

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
             driver.findElement(By.id(port)).sendKeys(rs.getString("name"));
		 System.out.println(rs.getString("name"));
		 System.out.println(rs.getInt("id"));
		 System.out.println(rs.getString("loaction"));
		 System.out.println(rs.getInt("age"));
		 
		}
	}

}
