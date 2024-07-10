package veg.vegi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import veg.vegi.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
