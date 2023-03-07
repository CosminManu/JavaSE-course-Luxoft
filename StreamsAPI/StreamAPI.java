package mar7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import feb20.lessons.Client;

public class StreamAPI {

	public static void main(String[] args) {

		Predicate<Client> checActive = Client::isActive;

		Stream<Integer> stream = Stream.of(1,2,3);
		stream.forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(10,20,30);
		list.forEach(System.out::println);
		
		Map<Integer, Double> bonuses = new HashMap<>();
		bonuses.put(4307, 40.01);
		
		Stream.of(new Client("Frank", 1001, true, 199.99),
				new Client("John", 2304, false, 299.99),
				new Client("Bob", 3305, false, 69.99),
				new Client("James", 4307, true, 99.99))
				//.filter(client -> client.getId() < 2000)
				//.filter(checActive.and(client -> client.getId() < 3000))
				.mapToDouble(client -> {
					double bonus = bonuses.getOrDefault(client.getId(), 0.0);
					return client.getBalance() + bonus;
				})
				.forEach(System.out::println);

	}
}
