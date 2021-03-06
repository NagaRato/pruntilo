package nl.kaiherwijn.pruntilo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class PruntiloApplicationTests {

	@Test
	void createTestImportSQL() {
		Random random = new Random();
		LocalDate startDateOfService = LocalDate.now().minusYears(5);
		for (int i = 0; i < 10; i++) {
			LocalDate lastTookDate = startDateOfService.plusDays(random.nextInt(10));
			LocalDate lastBroughtDate = lastTookDate.plusDays(random.nextInt(35));
			while (lastBroughtDate.getYear() < 2020) {
				System.out.println("insert into loaning(took, brought, stuff_id, member_id) values('" + lastTookDate.toString() + "', '" + lastBroughtDate.toString() + "', " + (i+1) + ", " + (random.nextInt(9)+1) + ");");
				lastTookDate = lastBroughtDate.plusDays(random.nextInt(10));
				lastBroughtDate = lastTookDate.plusDays(random.nextInt(35));
			}
		}
	}
}
