package me.adiberrifai.sfgpetclinic.services;

import me.adiberrifai.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Long id);

    Set<Pet> findAll();
}
