package kg.it_lab.backend.Flow.mapper;

import kg.it_lab.backend.Flow.dto.MeetExpertsResponse;
import kg.it_lab.backend.Flow.entities.MeetExperts;

public interface MeetExpertsMapper {
    MeetExpertsResponse toDto(MeetExperts meetExperts);
}
