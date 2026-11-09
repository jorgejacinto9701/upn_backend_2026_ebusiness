
package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Comentario;
import com.empresa.security.UsuarioPrincipal;
import com.empresa.service.ComentarioService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/comentario")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    // Todos pueden consultar los comentarios
    @GetMapping()
    public ResponseEntity<?> listaComentario() {

        List<Comentario> lista = service.listaComentario();

        return ResponseEntity.ok(lista);
    }

    // Todos pueden consultar comentarios por producto
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<?> listaPorProducto(
            @PathVariable int idProducto) {

        List<Comentario> lista =
                service.listaPorProducto(idProducto);

        return ResponseEntity.ok(lista);
    }

    // Solo usuarios autenticados pueden publicar
    @PostMapping()
    public ResponseEntity<?> registro(
            @RequestBody Comentario obj,
            Authentication authentication) {

        HashMap<String, Object> salida = new HashMap<>();

        // Obtener el usuario autenticado desde Spring Security
        UsuarioPrincipal usuario =
                (UsuarioPrincipal) authentication.getPrincipal();

        // Asignar automáticamente el ID del usuario autenticado
        obj.setIdUsuario(usuario.getIdUsuario());

        // Indicar que se trata de un comentario nuevo
        obj.setIdComentario(0);

        Comentario objSalida = service.inserta(obj);

        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");

        return ResponseEntity.ok(salida);
    }
}
