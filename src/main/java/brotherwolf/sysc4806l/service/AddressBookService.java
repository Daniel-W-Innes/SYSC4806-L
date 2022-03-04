package brotherwolf.sysc4806l.service;

import brotherwolf.sysc4806l.model.AddressBookModel;
import brotherwolf.sysc4806l.model.BuddyInfoModel;

import java.util.Set;

public interface AddressBookService {
    AddressBookModel newAddressBook(String addressBookName);

    void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel);

    void removeBuddy(String addressBookName, String firstName);

    Set<BuddyInfoModel> getBuddies(String addressBookName);
}
