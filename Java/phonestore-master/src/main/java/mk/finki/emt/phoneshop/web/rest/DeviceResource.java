package mk.finki.emt.phoneshop.web.rest;

import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/device")
public class DeviceResource {

    @Autowired
    private DeviceService service;

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> getAllDevices() {
        return new ArrayList<Device>(service.findAll());
    }

    @RequestMapping(method= RequestMethod.POST,value="/import", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> importDevices(@RequestBody @Valid ArrayList<Device> devices) {
        for (Device d:devices) {
            service.save(d);
        }
        return devices;
    }

    @RequestMapping(method=RequestMethod.GET, value="/category/{id}")
    public List<Device> getByCategoryId(@PathVariable("id") Long id) {
        return service.findByCategoryId(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/manufacturer/{name}")
    public List<Device> getByCategoryId(@PathVariable("name") String name) {
        return service.findByManufacturerNameLike(String.format("%%%s%%",name));
    }


    @RequestMapping(value = "/image/{device_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("device_id") Long deviceId) throws IOException {

        Device device = service.findOne(deviceId);
        byte[] imageContent = device.getPhotoData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
}
