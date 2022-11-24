package nl.belastingdienst.SpringBootSnow.mappers;

import nl.belastingdienst.SpringBootSnow.domain.Gear;
import nl.belastingdienst.SpringBootSnow.dtos.GearDto;

public class GearMapper {

    public static GearDto mapToDto(Gear gear) {
        GearDto dto = new GearDto();

        dto.setId(gear.getId());
        dto.setDiscipline(gear.getDiscipline());
        dto.setInUse(gear.isInUse());
        return dto;
    }

    public static Gear mapToEntity(GearDto gearDto){
        return mapToEntity(new Gear(), gearDto);
    }
    public static Gear mapToEntity(Gear gear, GearDto gearDto){
        gear.setInUse(gearDto.isInUse());
        gear.setDiscipline(gearDto.getDiscipline());
        return gear;
    }
}
