import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.badminton.app.AthleteAction;
import com.badminton.app.CoachAction;
import com.badminton.app.UserAction;
import com.badminton.entity.Athlete;


public class test {
	public static void main(String[] args) { 
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		//System.out.println(df.format(new java.util.Date()));// new Date()为获取当前系统时间
		
		UserAction useraction=new UserAction();
		int userid=1001;
		String username="詹姆斯";
		String password="男";
		//String	athlete_age="1980";
		//Date coach_age = Date.valueOf("1980-05-11");//把String转换成Date
		//int	event_id=1;
		String	role="1";
		//String	experience="1111111";
		//AthleteAction athleteaction=new AthleteAction();
		System.out.println(useraction.userDel(userid));

		//ArrayList<Athlete> arraylist=athleteaction.athleteList();
		//System.out.println(arraylist.get(1).getAthlete_id());
		//System.out.println(arraylist.get(1).getAthlete_age());

	}
}

