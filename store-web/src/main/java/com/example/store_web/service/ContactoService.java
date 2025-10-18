package com.example.store_web.service;

import com.example.store_web.model.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void guardar(Contacto contacto) {
    entityManager.persist(contacto);
  }
}
