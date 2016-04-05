package booking;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBook {

	List<Accommodation> accomodations;

	List<BookingPeriod> periods;

	List<Booking> bookings;

	@Before
	public void init() {

		Date from = getDate(2016, 5, 1);
		Date to = getDate(2016, 8, 27);
		
		Season season = createSeason(SeasonType.HIGH, from, to);
		RoomFair roomFair = createRoomFair(100, season);
		Accommodation accomodation = createNewRoom(AccommodationType.ROYAL, roomFair);
		
		accomodations = new ArrayList<Accommodation>();
		
		accomodations.add(accomodation);
		
		periods = new ArrayList<BookingPeriod>();
		
		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));
		periods.add(new BookingPeriod(getDate(2016, 6, 10), getDate(2016, 6, 13)));
		periods.add(new BookingPeriod(getDate(2016, 7, 5), getDate(2016, 7, 12)));
		periods.add(new BookingPeriod(getDate(2016, 8, 2), getDate(2016, 8, 4)));

		bookings = new ArrayList<Booking>();
		
		bookings.add(new Booking(accomodation, periods.get(0)));
		bookings.add(new Booking(accomodation, periods.get(1)));
		bookings.add(new Booking(accomodation, periods.get(2)));
		bookings.add(new Booking(accomodation, periods.get(3)));
	}

	@After
	public void destroy() {
		accomodations = null;
		periods = null;
		bookings = null;
	}

	@Test
	public void testBooking() {
		Date from = getDate(2016, 8, 5);
		Date to = getDate(2016, 8, 21);
		RoomFair roomFair = createRoomFair(100, createSeason(SeasonType.HIGH, from, to));
		assertFalse(createBooking(createNewRoom(AccommodationType.ROYAL, roomFair), AccommodationType.ROYAL, roomFair, from, to));
		System.out.println("Booked.");
	}

	@Test 
	public void testBookingExists() {
		Date from = getDate(2016, 8, 1);
		Date to = getDate(2016, 8, 5);
		RoomFair roomFair = createRoomFair(100, createSeason(SeasonType.HIGH, from, to));
		assertTrue(createBooking(createNewRoom(AccommodationType.ROYAL, roomFair), AccommodationType.ROYAL, roomFair, from, to));
		System.out.println("The booking exists! ");
	}
	
	@Test
	public void testDate() {
		Date from = getDate(2016, 8, 5);
		Date to = getDate(2016, 8, 1);
		boolean date = false;
		if (from.after(to)) {
			date = true;
		}
		assertTrue(date);
	}

	private boolean createBooking(Accommodation accomodation, AccommodationType type, RoomFair roomFair, Date from, Date to) {
		BookingPeriod bookingPeriod = new BookingPeriod(from, to);
		accomodation = createNewRoom(type, roomFair);
		
		boolean isBooked = false;
		
		for (Booking booking : bookings) {
			isBooked = booking.getRoom().getType().equals(type) && booking.getBookingPeriod().getFrom().after(from)
					&& booking.getBookingPeriod().getTo().before(to);
			if (isBooked) {
				break;
			}
		}
		if (!isBooked) {
			bookings.add(new Booking(accomodation, bookingPeriod));
		}
		return isBooked;
	}

	private Accommodation createNewRoom(AccommodationType type, RoomFair roomFair) {
		Accommodation accomodation = new Accommodation();
		accomodation.setType(type);
		accomodation.setFair(roomFair);
		return accomodation;
	}

	private RoomFair createRoomFair(int i, Season season) {
		RoomFair roomFair = new RoomFair();
		roomFair.setSeason(season);
		roomFair.setValue(i);
		return roomFair;
	}

	private Season createSeason(SeasonType type, Date from, Date to) {
		Season season = new Season();
		season.setFrom(from);
		season.setTo(to);
		season.setType(type);
		return season;
	}

	private Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		return calendar.getTime();
	}


}
