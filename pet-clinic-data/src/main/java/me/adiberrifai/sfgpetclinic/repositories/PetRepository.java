package me.adiberrifai.sfgpetclinic.repositories;

import me.adiberrifai.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
