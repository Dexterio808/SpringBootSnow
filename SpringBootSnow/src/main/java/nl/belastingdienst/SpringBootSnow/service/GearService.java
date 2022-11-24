package nl.belastingdienst.SpringBootSnow.service;

import nl.belastingdienst.SpringBootSnow.domain.Discipline;
import nl.belastingdienst.SpringBootSnow.domain.Gear;
import nl.belastingdienst.SpringBootSnow.dtos.GearDto;
import nl.belastingdienst.SpringBootSnow.mappers.GearMapper;
import nl.belastingdienst.SpringBootSnow.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class GearService implements Service<Gear, GearDto> {

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
    public Gear findById(Long id) {
        return gearRepository.findById(id).orElse(null);
    }

    @Override
    public void save(GearDto gearDto) {
        gearRepository.save(GearMapper.mapToEntity(gearDto));
    }

    @Override
    public void update(GearDto gearDto) {
       gearRepository.save(GearMapper.mapToEntity(findById(gearDto.getId()), gearDto));
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
