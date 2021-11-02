package nl.belastingdienst.SpringBootSnow;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceBP <T>{
    public List<T> findAll();

    public Optional<T> findById(Long id);

    public void save(T t);

    public void update(Long id, T t);

    public void delete(Long id);
}
