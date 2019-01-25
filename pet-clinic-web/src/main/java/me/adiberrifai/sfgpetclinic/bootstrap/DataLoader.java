package me.adiberrifai.sfgpetclinic.bootstrap;

import me.adiberrifai.sfgpetclinic.model.*;
import me.adiberrifai.sfgpetclinic.services.OwnerService;
import me.adiberrifai.sfgpetclinic.services.PetTypeService;
import me.adiberrifai.sfgpetclinic.services.SpecialityService;
import me.adiberrifai.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axie");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Smith");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
