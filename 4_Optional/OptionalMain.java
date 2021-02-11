package Chapter4;

import Chapter3.Stream2.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalMain {
	public static void main(String[] args) {

		List<Chapter3.Stream2.OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new Chapter3.Stream2.OnlineClass(1, "spring boot", true));
		springClasses.add(new Chapter3.Stream2.OnlineClass(2, "spring data jpa", true));
		springClasses.add(new Chapter3.Stream2.OnlineClass(3, "spring mvc", false));
		springClasses.add(new Chapter3.Stream2.OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		OnlineClass springBoot = new OnlineClass(1, "spring boot", true);

		/*
		//null pointer exception 발생
		Duration studyDuration = springBoot.getProgress().getStudyDuration();
		System.out.println(studyDuration);

		// 보통 null pointer exception을 방지하기 위한 코드 (null protection)
		Progress progress = springBoot.getProgress();
		// 아래 코드를 깜박하기 쉽다
		if (progress != null)
			System.out.println(progress.getStudyDuration());
		*/

		//getter에 Optional을 사용하여 null값을 받아오는것을 막을수 있다
		Optional<Progress> progress = springBoot.getProgress();
		progress.ifPresent(p -> System.out.println(p.getStudyDuration()));
		progress.ifPresent(p -> p.getStudyDuration());


		//primitive type에 대한 optional 사용
		// 아래 방식은 boxing, unboxing을 반복하므로 비효휼적
		Optional.of(10);
		//아래코드처럼 사용
		OptionalInt.of(10);
	}
}
