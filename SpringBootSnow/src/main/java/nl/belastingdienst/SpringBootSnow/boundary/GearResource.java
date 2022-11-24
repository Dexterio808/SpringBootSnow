package nl.belastingdienst.SpringBootSnow.boundary;

import nl.belastingdienst.SpringBootSnow.domain.Gear;
import nl.belastingdienst.SpringBootSnow.dtos.GearDto;
import nl.belastingdienst.SpringBootSnow.mappers.GearMapper;
import nl.belastingdienst.SpringBootSnow.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gear")
public class GearResource implements Resource<Gear, GearDto> {

    private final GearService gearService;

    @Autowired
    public GearResource(GearService gearService) {
        this.gearService = gearService;
    }


    @Override
    public List<GearDto> findAll() {
        List<GearDto> result = new ArrayList<>();
        gearService.findAll().forEach(e -> result.add(GearMapper.mapToDto(e)));
        return result;
    }

    @Override
    public GearDto findById(Long id) {
        return GearMapper.mapToDto(gearService.findById(id));
    }

    @Override
    public void save(GearDto gearDto) {
        gearService.save(gearDto);
    }

    @Override
    public void update(GearDto gearDto) {
        gearService.update(gearDto);
    }

    @Override
    public void delete(Long id) {
        gearService.delete(id);
    }
}
