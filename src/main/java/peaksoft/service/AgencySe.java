package peaksoft.service;

import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRe;

import java.util.List;

public interface AgencySe {
    void saveAgency(Agency agency);
    List<Agency> getAllAgency();
    AgencyRe getAgencyById(Long id);
    void updateAgency(Long id, Agency agency);
    void deleteAgencyById(Long id);
}
