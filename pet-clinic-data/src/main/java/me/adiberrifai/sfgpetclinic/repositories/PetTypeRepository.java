package me.adiberrifai.sfgpetclinic.repositories;

import me.adiberrifai.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
