package Chapter5;

import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeMain {
	public static void main(String[] args) throws InterruptedException {
		// date와 관련된 format
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat();

		/**
		 * 불편한점이 많은 것들이다
		 *
		 * - 이름(작명)이 제대로 되어있지 않다
		 *
		 * - mutalble한 객체 == Thread safe 하지 않다
		 *
		 * 이런 mutable한 것들은 멀티 스레드환경에서 안전하게 사용하기 위험하다
		 * ex)
		 * 쓰레드 t1에서 date값을 1 증가하는데 다른 쓰레드 t2에서 접근하여
		 * date값을 1 감소 시킨다면 t1이 끝나고 1이 증가가 되야 함에도
		 * 증가되지 않고 유지되는 등 다양한 오류가 생길 수 있다
		 * 이를 Thread safe 하지 않다고 표현한다
		 *
		 * - 버그 발생할 여지가 많다
		 *
		 */

		long time = date.getTime();
		System.out.println(time);
		System.out.println(date);
		// date에서 시간을 가져온다?
		// time은 실제 시간이 아닌 기준시 로부터 밀리 세컨을 센 값

		//3초재우기
		Thread.sleep(1000 * 3);
		Date after3Seconds = new Date();
		System.out.println(after3Seconds);
		//지난 과거의 시간을 가져와서 시간을 지정할 수 있다
		//time == Mon Oct 05 20:48:15 KST 2020
		after3Seconds.setTime(time);
		System.out.println(after3Seconds);
		//Mon Oct 05 20:48:18 KST 2020
		//Mon Oct 05 20:48:15 KST 2020

		//아래와 같이 생년월일을 표시할때 month에 경고를 날려주는데
		//Gregori에서 month가 0부터 시작하므로 0이 1월을 나타내게 된다
		//따라서 실수의 가능성이 높기 때문에 숫자대신 상수를 쓰도록 경고해주게 된다 -> Calendar.NOVEMBER
		Calendar woonsikBirthDay = new GregorianCalendar(1995, Calendar.NOVEMBER, 9);
		// type safty가 없다. 즉, 함수의 인자로 int형을 다 받을수 있게 되있어서 들어오는 인자가
		// 음수이든 범위를 넘는 숫자에 대한 보호가 안된다



		// 이런 기존 캘린더 대신 새로 들어온 시간 패키지
		/* 원칙
		JSR-310 스팩의 구현체를 제공한다.
		디자인 철학
		clear, fluent, immutable, extensible
		 */

		// 사람용 (human time) == localTime, localDate, localDate time
		// Duration(시간기반) 10초 후에, 5분 후에 ...
		// Period(날짜기반) 3일 후, 2주 후 ...
		// 등을 사용할수 있다


		// 기계용 (machin time)

		Date date1 = new Date();
		long time1 = date.getTime();
		System.out.println(time);
		//1601898495146

	}
}
