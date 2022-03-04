package brotherwolf.sysc4806l.controller;

import brotherwolf.sysc4806l.model.AddressBookModel;
import brotherwolf.sysc4806l.model.BuddyInfoModel;
import brotherwolf.sysc4806l.repository.AddressBookRepository;
import brotherwolf.sysc4806l.service.AddressBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GUIController {

    private final AddressBookRepository addressBookRepository;
    private final AddressBookService addressBookService;

    public GUIController(AddressBookRepository addressBookRepository, AddressBookService addressBookService) {
        this.addressBookRepository = addressBookRepository;
        this.addressBookService = addressBookService;
    }

    @GetMapping("{addressBookName}")
    public String getAddressBook(@PathVariable String addressBookName, Model model) {
        AddressBookModel addressBookModel = addressBookRepository.findByName(addressBookName);
        if (addressBookModel == null) {
            addressBookModel = addressBookService.newAddressBook(addressBookName);
        }
        model.addAttribute("AddressBookModel", addressBookModel);
        model.addAttribute("Buddies", addressBookModel.getBuddies());
        model.addAttribute("BuddyInfoModel", new BuddyInfoModel());
        return "AddressBook";
    }

    @RequestMapping("/")
    @ResponseBody
    String health() {
        return "Hello World!";
    }

}
