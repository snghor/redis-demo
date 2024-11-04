package ca.secy.demo.redis.documents.domain;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Searchable;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document
public class Company {
  @Id private String id;

  @NonNull @Searchable private String name;

  @Indexed private Set<String> tags = new HashSet<>();

  @NonNull private String url;

  @NonNull @Indexed private Point location;

  @NonNull @Indexed private Integer numberOfEmployees;

  @NonNull @Indexed private Integer yearFounded;

  private boolean publiclyListed;
}
