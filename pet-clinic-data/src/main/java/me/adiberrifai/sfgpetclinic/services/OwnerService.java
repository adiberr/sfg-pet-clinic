package me.adiberrifai.sfgpetclinic.services;

import me.adiberrifai.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
