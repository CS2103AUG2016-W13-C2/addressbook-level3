package seedu.addressbook.commands;

import java.util.ArrayList;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Search for person/s using a particular mobile number and list out all his/their personal information
 */

public class SearchCommand extends Command{
    
    public static final String COMMAND_WORD = "search";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Search for person/s using a mobile number and display "
            + "his/their personal information.\n\t"
            + "Example: " + COMMAND_WORD + " 83999015";
    
    private final String mobileNo;
    
    public SearchCommand(String mobile){
        mobileNo = mobile;
    }
    
    public String getMobileNo(){
        return mobileNo;
    }
    
    @Override
    public CommandResult execute() {
        final ArrayList<ReadOnlyPerson> personsFound = getPersonsWithSearchedMobileNo(mobileNo);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }
    
    /**
     * Retrieve person/s in the address book who is/are the owner of a mobile number.
     *
     * @param mobile number for searching
     * @return the person/s found
     */
    
    private ArrayList<ReadOnlyPerson> getPersonsWithSearchedMobileNo(String mobile){
        final ArrayList<ReadOnlyPerson> matchedPerson = new ArrayList<ReadOnlyPerson>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()){
            if(mobile.equals(person.getPhone().toString())){
                matchedPerson.add(person);
                }
            }
        return matchedPerson;
        
    }
    
    


}
