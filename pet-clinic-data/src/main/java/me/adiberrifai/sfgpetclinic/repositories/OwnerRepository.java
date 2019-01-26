package me.adiberrifai.sfgpetclinic.repositories;

import me.adiberrifai.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
