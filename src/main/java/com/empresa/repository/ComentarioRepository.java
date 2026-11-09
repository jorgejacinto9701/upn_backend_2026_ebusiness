
package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Comentario;

public interface ComentarioRepository
        extends JpaRepository<Comentario, Integer> {

    List<Comentario> findByIdProducto(int idProducto);

}
