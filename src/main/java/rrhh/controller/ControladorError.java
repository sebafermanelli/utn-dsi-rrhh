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
        String errorMessage = "Se produjo un error desconocido.";

        if (statusCode == HttpServletResponse.SC_NOT_FOUND) {
            errorMessage = "La página solicitada no existe.";
        } else if (statusCode == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
            errorMessage = "Se produjo un error interno en el servidor.";
        }

        model.addAttribute("errorCode", statusCode);
        model.addAttribute("errorMessage", errorMessage);

        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}