package mk.finki.emt.phoneshop.web.rest;

import mk.finki.emt.phoneshop.model.Manufacturer;
import mk.finki.emt.phoneshop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value="/rest/manufacturer")
public class ManufacturerResource {

    @Autowired
    private ManufacturerService service;


    @RequestMapping( method= RequestMethod.POST)
    public Manufacturer save(@RequestBody @Valid Manufacturer manufacturer) {
        service.save(manufacturer);
        return manufacturer;
    }

    @RequestMapping(method=RequestMethod.GET)
    public Collection<Manufacturer> list() {
        return service.findAll();
    }

}
