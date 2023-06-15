package rrhh.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorError implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletResponse response) {
        int statusCode = response.getStatus();

        model.addAttribute("errorCode", statusCode);

        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}