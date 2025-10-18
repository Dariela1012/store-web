package com.example.store_web.service;

public class ContactoService {

  private EntityManager entityManager;

  public void guardar(Contacto contacto) {
    entityManager.persist(contacto);
  }
}
