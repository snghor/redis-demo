package ca.secy.demo.redis.documents.runners;

import ca.secy.demo.redis.documents.domain.Company;
import ca.secy.demo.redis.documents.repositories.CompanyRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
@Order(1)
@Component
@RequiredArgsConstructor
public class RomsDocumentsApplication implements CommandLineRunner {
  private final CompanyRepository companyRepo;

  @Override
  public void run(String... args) {
    companyRepo.deleteAll();
    Company redis =
        Company.of("Redis", "https://redis.com", new Point(-122.066540, 37.377690), 526, 2011);
    redis.setTags(Set.of("fast", "scalable", "reliable"));

    Company microsoft =
        Company.of(
            "Microsoft", "https://microsoft.com", new Point(-122.124500, 47.640160), 182268, 1975);
    microsoft.setTags(Set.of("innovative", "reliable"));

    companyRepo.save(redis);
    companyRepo.save(microsoft);
  }
}
