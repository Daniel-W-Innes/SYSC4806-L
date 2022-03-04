package brotherwolf.sysc4806l.controller;

import brotherwolf.sysc4806l.model.BuddyInfoModel;
import brotherwolf.sysc4806l.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestParam String name) {
        try {
            addressBookService.newAddressBook(name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(name + " AddressBook created");
    }

    @PostMapping("/{addressBookName}/buddies")
    public ResponseEntity<?> add(@PathVariable("addressBookName") String addressBookName,
                                 @RequestBody BuddyInfoModel buddyInfoModel) {
        try {
            addressBookService.saveBuddy(addressBookName, buddyInfoModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(buddyInfoModel);
    }

    @PostMapping("/{addressBookName}/buddies/form")
    public ResponseEntity<?> add_form(@PathVariable("addressBookName") String addressBookName,
                                      @ModelAttribute BuddyInfoModel buddyInfoModel) {
        try {
            addressBookService.saveBuddy(addressBookName, buddyInfoModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(buddyInfoModel);
    }

    @GetMapping("/{addressBookName}/buddies")
    public ResponseEntity<?> get(@PathVariable("addressBookName") String addressBookName) {
        Set<BuddyInfoModel> buddies;
        try {
            buddies = addressBookService.getBuddies(addressBookName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no buddies in " + addressBookName);
        }
        return ResponseEntity.ok().body(buddies);
    }

    @DeleteMapping("/{addressBookName}/buddies/")
    public ResponseEntity<?> delete(@PathVariable("addressBookName") String addressBookName,
                                    @RequestParam String name) {
        try {
            addressBookService.removeBuddy(addressBookName, name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(name + " has been deleted");
    }
}
