package nl.kaiherwijn.pruntilo;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class PruntiloApplicationTests {

	@Test
	@Ignore
	void createTestImportSQL() {
		List parts = new ArrayList<String>();
		Random random = new Random();
		LocalDate startDateOfService = LocalDate.now().minusYears(1);
		for (int i = 0; i < 10; i++) {
			LocalDate lastTookDate = startDateOfService.plusDays(random.nextInt(10));
			LocalDate lastBroughtDate = lastTookDate.plusDays(random.nextInt(35));
			while (lastBroughtDate.isBefore(LocalDate.now())) {
				parts.add("('" + lastTookDate.toString() + "', '" + lastBroughtDate.toString() + "', " + (i+1) + ", " + (random.nextInt(9)+1) + "),");
				lastTookDate = lastBroughtDate.plusDays(random.nextInt(10));
				lastBroughtDate = lastTookDate.plusDays(random.nextInt(35));
			}
		}
		System.out.println("insert into loaning(take, bring, stuff_id, member_id)");
		parts.forEach(System.out::println);

	}

}
