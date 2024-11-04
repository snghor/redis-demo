package ca.secy.demo.redis.documents.repositories;

import ca.secy.demo.redis.documents.domain.Company;
import com.redis.om.spring.repository.RedisDocumentRepository;

/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
public interface CompanyRepository extends RedisDocumentRepository<Company, String> {}
