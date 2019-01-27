package me.adiberrifai.sfgpetclinic.services.springdatajpa;

import me.adiberrifai.sfgpetclinic.model.Pet;
import me.adiberrifai.sfgpetclinic.repositories.PetRepository;
import me.adiberrifai.sfgpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> petSet = new HashSet<>();
        petRepository.findAll().forEach(petSet::add);
        return petSet;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
