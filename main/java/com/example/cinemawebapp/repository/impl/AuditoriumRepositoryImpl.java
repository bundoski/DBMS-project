package com.example.cinemawebapp.repository.impl;

import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Auditorium;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuditoriumRepositoryImpl {

    public Auditorium save(Auditorium auditorium){
        if(auditorium==null || auditorium.getName_auditorium().isEmpty())
            return null;
        DataHolder.auditoriumList.removeIf(r -> r.getName_auditorium().equals(auditorium.getName_auditorium()));
        DataHolder.auditoriumList.add(auditorium);
        return auditorium;
    }
   public Optional<Auditorium> findByName(String name){
        return DataHolder.auditoriumList.stream()
                .filter(a -> a.getName_auditorium().equals(name)).findFirst();
   }

   public Optional<Auditorium> findById(Long id){
        return DataHolder.auditoriumList.stream()
                .filter(a -> a.getId_auditorium().equals(id)).findFirst();
   }

   public List<Auditorium> search(String text){
        return DataHolder.auditoriumList.stream()
                .filter(a -> a.getName_auditorium().contains(text)).collect(Collectors.toList());
   }

   public void deleteById(String name){
        DataHolder.auditoriumList.removeIf(a -> a.getName_auditorium().equals(name));
   }

}
