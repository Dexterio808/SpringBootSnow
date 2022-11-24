package nl.belastingdienst.SpringBootSnow.service;

import java.util.List;


public interface Service<Entity, Dto>{
    public List<Entity> findAll();

    public Entity findById(Long id);

    public void save(Dto entity);

    public void update(Dto entity);

    public void delete(Long id);
}
