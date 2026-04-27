package com.smart_road.transport.controller.page;

import com.smart_road.transport.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TransportPageController {
    private final TransportRepository transportRepository;

    @GetMapping("/transport")
    public String transportPage(Model model) {
        var transports = transportRepository.findAll();
        model.addAttribute("transports", transports);
        return "/transport";
    }
}