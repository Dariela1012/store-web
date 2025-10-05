package com.example.store_web.controller;

import com.example.store_web.model.Categoria;
import com.example.store_web.model.Contacto;
import com.example.store_web.model.Producto;
import com.example.store_web.service.CategoriaService;
import com.example.store_web.service.ContactoService;
import com.example.store_web.service.EmailService;
import com.example.store_web.service.ProductoService;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController{

    private final ContactoService contactoService;
    private final EmailService emailService;
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public PageController(ContactoService contactoService, EmailService emailService, ProductoService productoService, CategoriaService categoriaService) {
        this.contactoService = contactoService;
        this.emailService = emailService;
        this.productoService = productoService;
        this.categoriaService = categoriaService;

}

@GetMapping("/")
  public String homePage(Model model, HttpServletRequest request) {
    model.addAttribute("currentURI", request.getRequestURI());
    return "pages/index";
}

@PostMapping("/correo-enviado")
public String enviarFormularioContacto(Contacto contacto, Model model) {
  try {
      contacto.setFechaEnvio(LocalDateTime.now());

      contactoService.guardar(contacto);

      emailService.sendContactEmail(contacto, contacto.getMensaje());

      System.out.println("Mensaje de contacto recibido y correo enviado");
      System.out.println("Nombres: " + contacto.getNombre() + " " + contacto.getApellido());
      System.out.println("Numero: " + contacto.getNumero());
      System.out.println("Email: " + contacto.getCorreo());
      System.out.println("Mensaje: " + contacto.getMensaje());

      model.addAttribute("mensaje", "¡Gracias por tu interés! Ha sido enviado con éxito.");
      model.addAttribute("tipoMensaje", "success");
      model.addAttribute("mensaje", "Tu mensaje ha sido enviado. ¡Gracias!");
 
    }catch (Exception e) {
      System.err.println("Error al procesar formulario de contacto o enviar email: " + e.getMessage());
      model.addAttribute("mensaje", "Hubo un error al enviar tu mensaje. Por favor, inténtalo de nuevo más tarde.");
      model.addAttribute("tipoMensaje", "danger");
    }
    return "redirect:/";
}
