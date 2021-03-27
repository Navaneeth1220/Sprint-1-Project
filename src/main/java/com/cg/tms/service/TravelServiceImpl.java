package com.cg.tms.service;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.exceptions.InvalidTravelException;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.ITravelsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TravelServiceImpl implements ITravelsService{

    @Autowired
    private ITravelsRespository repository;

    @Override
    public Travels addTravels(Travels travels) {
        validateTravelsName(travels.getTravelsName());
        Travels saved=repository.save(travels);
        return saved;
    }

    @Override
    public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
        return null;
    }

    @Override
    public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
        Optional<Travels> optional = repository.findById(travelsId);
        if (!optional.isPresent()) {
        	throw new TravelsNotFoundException("travels not found for travelsid ="+travelsId );
        	
        }
        repository.deleteById(travelsId);
        
        return optional.get();
    }

    @Override
    public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
    	
    	Optional<Travels> optional = repository.findById(travelsId);
        if (!optional.isPresent()) {
        	throw new TravelsNotFoundException("travels not found for travelsid ="+travelsId );
        	
        }
        return optional.get();
    }

 

    
    public Travels viewTravels(int travlesId) throws TravelsNotFoundException {
		Optional<Travels> optional = repository.findById(travlesId);
		if(!optional.isPresent()) {
			throw new TravelsNotFoundException("Travels not found");
		}
		return optional.get();
	}

	@Override
	public List<Travels> viewTravels(){
		List<Travels> viewAll=repository.findAll();
		return viewAll;
	}
	public void validateTravelsName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new InvalidTravelException("travelname is null or empty");
        }
    }	

	void validateTravelscontacts(String contacts) {
		if (contacts == null || contacts.isEmpty() || contacts.trim().isEmpty()) {
			throw new InvalidTravelException("Check travel contact");
		}
	}
	
	void validateTravelsaddress(String address) {
		if (address == null || address.isEmpty() || address.trim().isEmpty()) {
			throw new InvalidTravelException("Check Travel address");
		}
	}


}
