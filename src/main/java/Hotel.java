import java.security.spec.ECField;
import java.util.ArrayList;

public class Hotel implements ICheckGuest{
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<EventRoom> eventrooms;
//    private DiningRoom  diningRoom;
//    private ConferenceRoom conferenceRoom;

    public Hotel(String name) {
        this.name = name;
        bedrooms = new ArrayList<Bedroom>();
        this.eventrooms = new ArrayList<>();
    }

    public void addEventRoom(EventRoom eventRoom) {
        this.eventrooms.add(eventRoom);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return new ArrayList<Bedroom>(bedrooms);
    }

    public void setBedrooms(ArrayList<Bedroom> bedrooms) {
        this.bedrooms = bedrooms;
    }

//    public DiningRoom getDiningRoom() {
//        return diningRoom;
//    }

    public ArrayList<EventRoom> getEventrooms() {
        return new ArrayList<EventRoom>(eventrooms);
    }

//    getDiningRoom() {
//        return eventrooms;
//    }

//   public void setDiningRoom(DiningRoom diningRoom) {
//        this.diningRoom = diningRoom;
//    }

    public void setEventRooms(ArrayList<EventRoom> eventrooms) {
        this.eventrooms = eventrooms;
    }
//    public void setDiningRoom(DiningRoom diningRoom) {
//        this.diningRoom = diningRoom;
//    }

//    public ConferenceRoom getConferenceRoom() {
//        return this.conferenceRoom;
//    }

//    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
//        this.conferenceRoom = conferenceRoom;
//    }

    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void checkInGuestToEventRoom(ArrayList<Guest> guests, String roomName) {
        for(EventRoom room : this.eventrooms) {
            if(room.getName().equals(roomName)) {
                room.checkInGuests(guests);
                return;
            }
        }
    }
//
//    public void checkInGuestsToDiningRoom(ArrayList<Guest> guests) {
//        this.diningRoom.checkInGuests(guests);
//    }
//
//    public void checkInGuestsToConferenceRoom(ArrayList<Guest> guests) {
//        this.conferenceRoom.checkInGuests(guests);
//    }

    public ArrayList<Guest> getGuestsCheckedIntoBedroom(int number) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                return room.getGuests();
            }
        }
        return new ArrayList<Guest>();
    }

    public void checkGuestsIntoBedroom(int number, ArrayList<Guest> guestList) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkInGuests(guestList);
                return;
            }
        }
    }

    public void checkGuestsIntoBedroomForNumberOfNights(int number, ArrayList<Guest> guestList, int numberOfNights) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkInGuestsForNumberOfNights(guestList, numberOfNights);
                return;
            }
        }
    }

    public void checkGuestsOutOfBedroom(int number) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkOut();
                return;
            }
        }
    }

    public ArrayList<Bedroom> getAvailableBedrooms() {
        ArrayList<Bedroom> availableRooms = new ArrayList<Bedroom>();
        for (Bedroom room : bedrooms) {
            if (room.isVacant()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public String checkInGuests(String data) {
        return null;
    }

    public int getNumberOfEventRooms() {
        return this.eventrooms.size();
    }

}
