package mk.finki.emt.phoneshop.service.impl;

import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.service.DeviceService;
import mk.finki.emt.phoneshop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private DeviceService deviceService;

    @Override
    public void saveFile(Device device, MultipartFile file) {
        try {
            device.setPhotoData(file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        deviceService.save(device);



    }
}
