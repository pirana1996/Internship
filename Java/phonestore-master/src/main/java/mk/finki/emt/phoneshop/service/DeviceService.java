package mk.finki.emt.phoneshop.service;

import mk.finki.emt.phoneshop.model.Device;

import java.util.List;

public interface DeviceService extends BaseEntityService<Device> {


    List<Device> findByCategoryId(Long id);
    List<Device> findByManufacturerNameLike(String name);
}
