package com.example.store_web.service;

import com.example.store_web.model.AdminUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class AdminService{

    @PersistenceContext
    private EntityManager entityManager;

    public AdminUsuario buscarPorUsuario(String usuario){
        try{
            return entityManager.createQuery("SELECT a FROM AdminUsuario a WHERE a.usuario = :usuario", AdminUsuario.class)
                    .setParameter("Usuario", usuario)
                    .getSingleResult();    
        } catch(NoResultException e){
            return null;
        }
    }
}