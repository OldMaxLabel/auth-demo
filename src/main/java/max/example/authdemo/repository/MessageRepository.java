package max.example.authdemo.repository;

import max.example.authdemo.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
