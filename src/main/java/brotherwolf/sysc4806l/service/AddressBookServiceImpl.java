package brotherwolf.sysc4806l.service;

import brotherwolf.sysc4806l.model.AddressBookModel;
import brotherwolf.sysc4806l.model.BuddyInfoModel;
import brotherwolf.sysc4806l.repository.AddressBookRepository;
import brotherwolf.sysc4806l.repository.BuddyInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    public AddressBookServiceImpl(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }


    @Override
    public AddressBookModel newAddressBook(String addressBookName) {
        AddressBookModel addressBookModel = addressBookRepository.findByName(addressBookName);
        if (addressBookModel == null) {
            addressBookModel = new AddressBookModel(addressBookName);
        }
        addressBookRepository.save(addressBookModel);
        return addressBookModel;
    }

    @Override
    public void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel) {
        buddyInfoModel = buddyInfoRepository.save(buddyInfoModel);
        AddressBookModel addressBookModel = addressBookRepository.findByName(addressBookName);
        addressBookModel.addBuddy(buddyInfoModel);
        addressBookRepository.save(addressBookModel);
    }

    @Override
    public void removeBuddy(String addressBookName, String name) {
        BuddyInfoModel buddyInfoModel = buddyInfoRepository.findByName(name);
        AddressBookModel addressBookModel = addressBookRepository.findByName(addressBookName);
        addressBookModel.removeBuddy(name);
        buddyInfoRepository.delete(buddyInfoModel);
        addressBookRepository.save(addressBookModel);
    }

    @Override
    public Set<BuddyInfoModel> getBuddies(String addressBookName) {
        return addressBookRepository.findByName(addressBookName).getBuddies();
    }
}
