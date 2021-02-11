package Chapter4;

import Chapter3.Stream2.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApiMain {
	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(5, "rest api development", false));

//값이 있을수도 없을수도 있으므르 Optional 자료형으로 잡힌다
		Optional<OnlineClass> springOptional = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.findFirst();

		Optional<OnlineClass> jpaOptional = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("jpa"))
				.findFirst();

		boolean presentSpring = springOptional.isPresent();
		System.out.println(presentSpring);

		boolean presentJpa = jpaOptional.isPresent();
		System.out.println(presentJpa);

//아래와 같은 코드를 사용하면 Optional 값으로부터 값을 가져올수 있지만
//비어있는 옵셔널 값일지라도 수행하게 되므로 NoSuchElementException 오류가 발생할수 있다
		OnlineClass onlineClass = springOptional.get();
		System.out.println(onlineClass.getTitle());

//따라서 아래와 같이 수정을 해서 값이 있는지 확인을 하고 꺼내야 한다
		if (jpaOptional.isPresent()) {
			OnlineClass jpaClass = jpaOptional.get();
			System.out.println(jpaClass.getTitle());
		}

//혹은, 다양한 Optional API를 활용해서 get()대신 다양한 메서드를 이용해서 처리할 수 있다
		OnlineClass jpaClass = jpaOptional.orElse(null);
//System.out.println(jpaClass.getTitle());

/*
옵셔널 api 활용
 */

//옵셔널에 값이 들어있을때 무언가를 해야한다면
		jpaOptional.ifPresent(oc -> System.out.println(oc.getTitle()));
		springOptional.ifPresent(oc -> System.out.println(oc.getTitle()));

		System.out.println("=============");
//옵셔널 값을 가져오고 추가적인 행동을 할 경우 orElse(클래스의 인스턴스 전달만 가능)
//값이 있든 없는 일단 createNewJapClass()코드는 실행이 된다 이후 전달의 차이
		OnlineClass onelineClass = springOptional.orElse(createNewJpaClass());
		OnlineClass onelineClass1 = jpaOptional.orElse(createNewJpaClass());

		System.out.println("=============");
//옵셔널 값을 가져오고 추가적인 행동을 할 경우 orElseGet(서플라이어 사용 가능)
//값이 있는 경우에만 createNewJapClass코드 실행
		OnlineClass onlineClass4 = jpaOptional.orElseGet(() -> createNewJpaClass());
		System.out.println(onlineClass4.getTitle());
//람다 표현식으로 전환
		jpaOptional.orElseGet(OptionalApiMain::createNewJpaClass);//메서드 레퍼런스
		springOptional.orElseGet(OptionalApiMain::createNewJpaClass);

// 이미 만들어져있는 인스턴스나 동적인 자료에 대해 참고해서 작업시 orElse를 사용하는것이 좋고
// 동적으로 작업을하면서 만들어내거나, 동작을 추가로 해야한다면 orElseGet을 사용하는것이 좋다

		System.out.println("=============");
//orElseThrow()
//없으면은 error를 던진다, 원하는 에러가있다면 지정할수 있다
		OnlineClass onlineClass1 = springOptional.orElseThrow(() -> {
			return new IllegalArgumentException();
		});
//람다 표현식으로 전환
		OnlineClass onlineClass2 = springOptional.orElseThrow(IllegalAccessError::new);
		System.out.println(onlineClass2.getTitle());

		System.out.println("=============");
		Optional<OnlineClass> onlineClass3 = jpaOptional
				.filter(oc -> oc.getId() > 10);
		System.out.println(onlineClass3); // <- 필터의 조건에 맞지않아서 empty optional이 온 경우

		Optional<OnlineClass> onlineClass5 = springOptional
				.filter(oc -> oc.getId() == 1);
		onlineClass5.ifPresent(oc -> System.out.println(oc.getTitle()));

		System.out.println("=============");
		Optional<Integer> springId = springOptional
				.map(OnlineClass::getId);
		springId.ifPresent(System.out::println); // map을 통해 id값만 가져온경우

		System.out.println("=============");
//옵셔널값에서 맵으로 받아온 값이 옵셔널일 경우 옵셔널을 옵셔널로 감싸서 받아서 까야된다
		Optional<Optional<Progress>> progress = springOptional.map(OnlineClass::getProgress);
		Optional<Progress> progress1 = progress.orElse(Optional.empty()); // <-값이 없으면 empty optional이 온다
//Progress progress2 = progress1.orElseThrow();
//System.out.println(progress2.getStudyDuration());

		System.out.println("=============");
// Optional의 flatMap (stream에서의 사용과는 또 다르다)
// 이런 경우 사용하는 경우 -> flatMap을 사용
// 현재 매핑해서 꺼내는 타입이 옵셔널일 경우 안에서 먼저 옵셔널을 벗겨내준다
// -> 두번 옵셔널을 벗겨내는 과정을 한번으로 줄여준다
		Optional<Progress> progress3 = springOptional.flatMap(OnlineClass::getProgress);
//Progress progress4 = progress3.orElseThrow();
//System.out.println(progress4.getStudyDuration());

//stream에서의 flatMap이랑과는 다르다 -> 여기서는 1대1 매핑
		springClasses.stream().flatMap(o -> o.getProgress().stream());
	}

	private static OnlineClass createNewJpaClass() {
		System.out.println("creating new online class");
		return new OnlineClass(10, "New Class", false);
	}
}
