package nl.belastingdienst.SpringBootSnow.boundary;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Resource<Entity ,Dto>{

    @GetMapping
    public List<Dto> findAll();

    @GetMapping(path = "/{id}")
    public Dto findById(@PathVariable Long id);

    @PostMapping(path = "/save")
    public void save(@RequestBody Dto dto);

    @PutMapping(path = "/update/")
    public void update(@RequestBody Dto dto);

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id);

}
