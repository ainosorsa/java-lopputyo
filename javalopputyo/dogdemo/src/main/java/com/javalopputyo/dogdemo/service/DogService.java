package com.javalopputyo.dogdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.javalopputyo.dogdemo.data.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public List<Dog> getDogs(){
        return new ArrayList<>(dogs);
    }

    public boolean removeDog(String breed) {
        Dog d = getBreed(breed);

        if (d != null) {
            return dogs.remove(d);
        } else {
            return false;
        }

    } 

    private Dog getBreed(String breed) {
        return null;
    }

    public List<Dog> getDogsByBreed(String breed){
        List<Dog> foundBreed = new ArrayList<>();

        for(Dog d : dogs){
            if(d.getBreed().equals(breed)){
                foundBreed.add(d);
            }
        }

        return foundBreed;
    }

    public List<Dog> getDogsByName(String name){
        List<Dog> foundName = new ArrayList<>();

        for(Dog d : dogs){
            if(d.getName().equals(name)){
                foundName.add(d);
            }
        }

        return foundName;
    }


}
