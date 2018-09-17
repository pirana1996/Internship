package mk.finki.emt.phoneshop.service;

import mk.finki.emt.phoneshop.model.Device;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    public void saveFile(Device device, MultipartFile file);
}
