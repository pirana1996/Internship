package mk.finki.emt.phoneshop.web.controllers;

import mk.finki.emt.phoneshop.config.Layout;
import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.service.CategoryService;
import mk.finki.emt.phoneshop.service.DeviceService;
import mk.finki.emt.phoneshop.service.ManufacturerService;
import mk.finki.emt.phoneshop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private StorageService storageService;

    @Layout("layout/master")
    @GetMapping("/add")
    public String addDevice(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("device", new Device());
        return "forms/device.Add";
    }

    @Layout("layout/master")
    @PostMapping(value="/save")
    public String saveDevice(@ModelAttribute Device device, @RequestParam("file") MultipartFile file, Model model) {
        model.addAttribute("categories",categoryService.findAll());
        deviceService.save(device);
        storageService.saveFile(device,file);
        return "common/success";
    }
}
