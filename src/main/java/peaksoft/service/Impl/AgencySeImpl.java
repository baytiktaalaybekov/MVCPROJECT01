package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRe;
import peaksoft.service.AgencySe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencySeImpl implements AgencySe {

    private final AgencyRe agencyRe;

    @Override
    public void saveAgency(Agency agency) {
        agencyRe.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyRe.getAllAgency();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRe.getAgencyById(id);
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        agencyRe.updateAgency(id,agency);

    }

    @Override
    public void deleteAgencyById(Long id) {
        agencyRe.deleteAgencyById(id);

    }
}
