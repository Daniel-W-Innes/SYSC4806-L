package brotherwolf.sysc4806l.repository;

import brotherwolf.sysc4806l.model.AddressBookModel;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBookModel, Long> {
    AddressBookModel findByName(String name);
}