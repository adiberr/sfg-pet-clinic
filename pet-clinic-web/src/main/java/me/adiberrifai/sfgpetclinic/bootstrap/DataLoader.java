package me.adiberrifai.sfgpetclinic.bootstrap;

import me.adiberrifai.sfgpetclinic.model.Owner;
import me.adiberrifai.sfgpetclinic.model.Pet;
import me.adiberrifai.sfgpetclinic.model.PetType;
import me.adiberrifai.sfgpetclinic.model.Vet;
import me.adiberrifai.sfgpetclinic.services.OwnerService;
import me.adiberrifai.sfgpetclinic.services.PetTypeService;
import me.adiberrifai.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes ...");

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet johnsPet = new Pet();
        johnsPet.setName("Rex");
        johnsPet.setPetType(savedDogPetType);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setOwner(owner1);
        owner1.getPets().add(johnsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123456789");

        Pet janePet = new Pet();
        janePet.setName("Miau");
        janePet.setPetType(savedCatPetType);
        janePet.setBirthDate(LocalDate.now());
        janePet.setOwner(owner2);
        owner2.getPets().add(janePet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axie");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
