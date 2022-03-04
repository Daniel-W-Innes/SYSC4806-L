package brotherwolf.sysc4806l.repository;

import brotherwolf.sysc4806l.model.BuddyInfoModel;
import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfoModel, Long> {
    BuddyInfoModel findByName(String name);
}