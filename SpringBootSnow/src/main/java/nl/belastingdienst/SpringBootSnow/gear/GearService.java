package nl.belastingdienst.SpringBootSnow.gear;

import nl.belastingdienst.SpringBootSnow.bluePrints.ServiceBP;
import nl.belastingdienst.SpringBootSnow.enums.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GearService implements ServiceBP<Gear> {

    private final GearRepository gearRepository;

    @Autowired
    public GearService(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }

    @Override
    public List<Gear> findAll() {
        return gearRepository.findAll();
    }

    @Override
    public Optional<Gear> findById(Long id) {
        return gearRepository.findById(id);
    }

    @Override
    public void save(Gear gear) {
        gearRepository.save(gear);
    }

    @Override
    public void update(Long id, Gear gear) {
        if (gearRepository.existsById(id)) {
            Gear g = gearRepository.findById(id).get();
            g.setInUse(gear.isInUse());
            g.setDiscipline(gear.getDiscipline());
            gearRepository.save(gear);
        }
    }

    @Override
    public void delete(Long id) {
        if (gearRepository.existsById(id)) {
            gearRepository.delete(gearRepository.getById(id));
        }
    }

    public Gear allocateGear(Discipline discipline){
        Gear s = gearRepository.findFirstByDisciplineAndAndInUseFalse(discipline);
        if (s != null) {
            s.setInUse(true);
            gearRepository.save(s);
        }
        return s;
    }

    public boolean deallocateGear(Long gearId){
        Gear s = gearRepository.findById(gearId).get();
        s.setInUse(false);
        gearRepository.save(s);
        return true;
    }

}
