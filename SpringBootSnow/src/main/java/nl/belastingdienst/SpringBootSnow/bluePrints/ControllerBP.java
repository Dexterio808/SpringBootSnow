package nl.belastingdienst.SpringBootSnow.bluePrints;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ControllerBP <T>{

    @GetMapping
    public List<T> findAll();

    @GetMapping(path = "/{id}")
    public Optional<T> findById(@PathVariable Long id);

    @PostMapping(path = "/save")
    public void save(@RequestBody T t);

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable Long id, @RequestBody T t);

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id);

}
