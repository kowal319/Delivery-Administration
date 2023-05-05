package delivery.Repository;

import delivery.Entity.Tracking;
import org.springframework.data.repository.CrudRepository;

public interface TrackingRepository extends CrudRepository<Tracking, Long> {
}
