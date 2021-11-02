package nl.belastingdienst.SpringBootSnow.gear;

import nl.belastingdienst.SpringBootSnow.bluePrints.ControllerBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/gear")
public class GearController implements ControllerBP<Gear> {

    private final GearService gearService;

    @Autowired
    public GearController(GearService gearService) {
        this.gearService = gearService;
    }


    @Override
    public List<Gear> findAll() {
        return gearService.findAll();
    }

    @Override
    public Optional<Gear> findById(Long id) {
        return gearService.findById(id);
    }

    @Override
    public void save(Gear gear) {
        gearService.save(gear);
    }

    @Override
    public void update(Long id, Gear gear) {
        gearService.update(id, gear);
    }

    @Override
    public void delete(Long id) {
        gearService.delete(id);
    }
}
