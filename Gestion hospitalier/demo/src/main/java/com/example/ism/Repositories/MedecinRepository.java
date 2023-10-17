package com.example.ism.Repositories;
import java.util.List;
import com.example.ism.Entities.Medecin;

public interface MedecinRepository<T> {
    void insert(Medecin medecin);
    void update(Medecin medecin);
    void delete(int id);
    Medecin findById(int id);
    List<Medecin> findAll();
}