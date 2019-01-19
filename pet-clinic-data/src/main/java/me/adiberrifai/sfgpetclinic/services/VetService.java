package me.adiberrifai.sfgpetclinic.services;

import me.adiberrifai.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Long id);

    Set<Vet> findAll();
}
