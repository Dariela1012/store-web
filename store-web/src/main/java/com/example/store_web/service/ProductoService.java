package com.example.store_web.service;

import com.example.store_web.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void guardar(Producto producto) {
    entityManager.persist(producto);
  }

  @Transactional
  public String actualizar(Producto productoNuevo, int id) {
    String message = "mensaje";
    Producto producto = entityManager.find(Producto.class, id);
    // Actualizar datos
    producto.setNombre(productoNuevo.getNombre());
    producto.setDescripcion(productoNuevo.getDescripcion());
    producto.setPrecio(productoNuevo.getPrecio());
    producto.setImagenUrl(productoNuevo.getImagenUrl());
    producto.setTalla(productoNuevo.getTalla());
    producto.setGenero(productoNuevo.getGenero());
    producto.setEdadSugerida(productoNuevo.getEdadSugerida());
    producto.setCategoria(productoNuevo.getCategoria());
    entityManager.merge(producto);

    message = "¡Producto actualizado correctamente!";
    return message;
   }

}