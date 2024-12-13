package com.example.HastaneSistemi.viewcontroller;

import com.example.HastaneSistemi.model.HospitalRooms;
import com.example.HastaneSistemi.service.HospitalRoomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/rooms")
public class HospitalRoomsViewController {
    private final HospitalRoomsService hospitalRoomsService;
    public HospitalRoomsViewController(HospitalRoomsService hospitalRoomsService) {
        this.hospitalRoomsService = hospitalRoomsService;
    }
    @GetMapping()
    public String getAllRooms(Model model) {
        List<HospitalRooms> hospitalRooms = hospitalRoomsService.getAllRooms();
        model.addAttribute("hospitalRooms", hospitalRooms);
        return "room-list";

    }
    @GetMapping("/{id}")
    public  String getRoomById(@PathVariable Integer id, Model model) {
        Optional<HospitalRooms> room= hospitalRoomsService.getRoomById(id);
        room.ifPresent(value->model.addAttribute("rooms",value));
        return room.isPresent() ? "room_detail" : "error";
    }
    @GetMapping("/add")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new HospitalRooms());
        return "room-add";

    }
    @PostMapping
    public String addRoom(@ModelAttribute HospitalRooms room) {
        hospitalRoomsService.addRoom(room);
        return "redirect:/api/rooms";
    }
    @GetMapping("/edit/{id}")
    public String showEditRoomForm(Model model,@PathVariable Integer id) {
        Optional<HospitalRooms> room = hospitalRoomsService.getRoomById(id);
        room.ifPresent(value -> model.addAttribute("hospitalRoom", value));
        return room.isPresent() ? "edit_room" : "error";
    }
    @PostMapping("edit/{id}")
    public String editRoom(@ModelAttribute HospitalRooms room,@PathVariable Integer id) {
        hospitalRoomsService.updateRoom(id, room);
        return "redirect:/api/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable int id) {
        hospitalRoomsService.deleteRoom(id);
        return "redirect:/api/rooms"; // Oda silindikten sonra oda listesine yönlendirme
    }



}
