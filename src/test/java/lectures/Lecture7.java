package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

	@Test
	public void count() throws Exception {
		long femaleCount = MockData.getPeople()
				.stream()
				.filter(person -> person
						.getGender()
						.equalsIgnoreCase("female"))
				.count();

		System.out.println(femaleCount);

	}

	@Test
	public void min() throws Exception {
		double min = MockData.getCars()
				.stream()
				.filter(car -> car
						.getColor()
						.equalsIgnoreCase("yellow"))
				.mapToDouble(Car::getPrice)
				.min()
				.getAsDouble();

		System.out.println(min);
	}

	@Test
	public void max() throws Exception {

		double max = MockData.getCars()
				.stream()
				.filter(car -> car
						.getColor()
						.equalsIgnoreCase("yellow"))
				.mapToDouble(Car::getPrice)
				.max()
				.orElse(0);

		System.out.println(max);

	}


	@Test
	public void average() throws Exception {
		List<Car> cars = MockData.getCars();

		double average = cars.stream()
				.mapToDouble(Car::getPrice)
				.average()
				.orElse(0);

		System.out.println(average);

	}

	@Test
	public void sum() throws Exception {
		List<Car> cars = MockData.getCars();
		double sum = cars.stream()
				.mapToDouble(Car::getPrice)
				.sum();

		BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);

		System.out.println(bigDecimalSum);

	}

	@Test
	public void statistics() throws Exception {
		List<Car> cars = MockData.getCars();
		DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
				.mapToDouble(Car::getPrice)
				.summaryStatistics();

		System.out.println(doubleSummaryStatistics);
	}

}