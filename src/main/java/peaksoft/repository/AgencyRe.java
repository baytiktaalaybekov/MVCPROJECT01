package peaksoft.repository;

import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyRe {
    void saveAgency(Agency agency);
    List<Agency> getAllAgency();
    AgencyRe getAgencyById(Long id);
    void updateAgency(Long id, Agency agency);
    void deleteAgencyById(Long id);

}
