package com.javalopputyo.dogdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalopputyo.dogdemo.data.Dog;
import com.javalopputyo.dogdemo.service.DogService;
import com.javalopputyo.dogdemo.controller.DogRestController;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;




@RestController
public class DogRestController {
    
    private DogService dService = new DogService();

   
    @GetMapping("/dogs")
    public List<Dog> getDogs(){
        return dService.getDogs();
    }

    @GetMapping("/dog/breed/{breed}")
    public List<Dog> getDogsByBreed(@PathVariable String breed){
        return dService.getDogsByBreed(breed);
    }

    @PostMapping("/adddog")
    public String addDog(@RequestBody Dog dog){
        dService.addDog(dog);
        return "Dog added";
    }

    @DeleteMapping("/deletedog")
    public String deleteDog(@RequestBody Dog dog) {
        if(dService.removeDog(dog.getBreed())==true){
        return "dog removed";
        }
        else {
            return "Couldn't remove dog";
        }
    }

    @GetMapping("/dog/name/{name}")
    public List<Dog> getDogsByName(@PathVariable String name){
        return dService.getDogsByName(name);
    }


    }


