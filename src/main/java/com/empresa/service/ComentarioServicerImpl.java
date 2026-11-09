
package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Comentario;
import com.empresa.entity.Usuario;
import com.empresa.repository.ComentarioRepository;
import com.empresa.repository.UsuarioRepository;

@Service
public class ComentarioServicerImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los comentarios con nombre de usuario
    @Override
    public List<Comentario> listaComentario() {

        List<Comentario> comentarios = repository.findAll();

        completarNombres(comentarios);

        return comentarios;
    }

    // Obtener comentarios de un producto con nombre de usuario
    @Override
    public List<Comentario> listaPorProducto(int idProducto) {

        List<Comentario> comentarios =
                repository.findByIdProducto(idProducto);

        completarNombres(comentarios);

        return comentarios;
    }

    // Registrar un comentario nuevo
    @Override
    public Comentario inserta(Comentario obj) {

        Comentario comentarioGuardado = repository.save(obj);

        completarNombre(comentarioGuardado);

        return comentarioGuardado;
    }

    // Completar los nombres de una lista de comentarios
    private void completarNombres(List<Comentario> comentarios) {

        for (Comentario comentario : comentarios) {
            completarNombre(comentario);
        }
    }

    // Buscar el nombre completo del autor en MySQL
    private void completarNombre(Comentario comentario) {

        Usuario usuario = usuarioRepository
                .findById(comentario.getIdUsuario())
                .orElse(null);

        if (usuario != null) {
            comentario.setNombreUsuario(
                    usuario.getNombreCompleto()
            );
        } else {
            comentario.setNombreUsuario("Usuario no disponible");
        }
    }
}
