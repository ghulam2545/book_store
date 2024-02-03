package com.ghulam.store.converters;

import com.ghulam.store.dtos.request.AddressRequestDto;
import com.ghulam.store.models.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToAddress implements Converter<AddressRequestDto, Address> {
    @Override
    public Address convert(AddressRequestDto source) {
        Address address = new Address();

        address.setBuildingNumber(source.buildingNumber());
        address.setStreetName(source.streetName());
        address.setVillage(source.village());
        address.setCity(source.city());
        address.setState(source.state());
        address.setPincode(source.pincode());

        return address;
    }
}
