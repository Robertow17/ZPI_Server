package com.zpi.transport_details;

import com.zpi.category.Category;
import com.zpi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportDetailsService
{
    @Autowired
    private TransportDetailsRepository transportDetailsRepository;


    public List<TransportDetails> findAll()
    {
        return transportDetailsRepository.findAll();
    }


    public Optional<TransportDetails> findById(int id)
    {
        return transportDetailsRepository.findById(id);

    }


    public TransportDetails save(TransportDetails transportDetails)
    {
        return transportDetailsRepository.save(transportDetails);
    }


    public void deleteById(int id)
    {
        transportDetailsRepository.deleteById(id);
    }
}
