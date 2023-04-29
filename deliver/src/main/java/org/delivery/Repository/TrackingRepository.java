package org.delivery.Repository;

import org.delivery.Entity.Tracking;
import org.springframework.data.repository.CrudRepository;

public interface TrackingRepository extends CrudRepository<Tracking, Long> {
}
