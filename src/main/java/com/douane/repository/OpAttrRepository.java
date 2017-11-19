package com.douane.repository;

import java.util.List;

import com.douane.entite.*;
import com.douane.model.EtatOperation;
import org.springframework.data.repository.CrudRepository;

public interface OpAttrRepository extends CrudRepository<OpAttribution, Long>{
    public List<OpAttribution> findAll();
    public List<OpAttribution> findByOperateur(Agent operateur);
    public List<OpAttribution> findByDirection(Direction direction);
    public List<OpAttribution> findByMat(Materiel m);
    public List<OpAttribution> findByMatAndState(Materiel m, EtatOperation e);

}
