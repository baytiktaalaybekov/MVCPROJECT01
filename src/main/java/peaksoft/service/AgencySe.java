package peaksoft.service;

import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRe;

import java.util.List;
import java.util.Optional;

public interface AgencySe {
    void saveAgency(Agency agency);
    List<Agency> getAllAgency();
    Agency getAgencyById(Long id);
    void updateAgency(Long id, Agency agency);
    void deleteAgencyById(Long id);
}
