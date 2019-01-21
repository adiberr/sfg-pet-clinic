package me.adiberrifai.sfgpetclinic.bootstrap;

import me.adiberrifai.sfgpetclinic.model.Owner;
import me.adiberrifai.sfgpetclinic.model.Vet;
import me.adiberrifai.sfgpetclinic.services.OwnerService;
import me.adiberrifai.sfgpetclinic.services.VetService;
import me.adiberrifai.sfgpetclinic.services.map.OwnerServiceMap;
import me.adiberrifai.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axie");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("John");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
