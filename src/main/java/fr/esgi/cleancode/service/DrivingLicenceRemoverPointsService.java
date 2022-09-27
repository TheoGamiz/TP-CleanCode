package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DrivingLicenceRemoverPointsService {

    private DrivingLicenceFinderService serviceFinder;

    public DrivingLicence removePoints(int point,DrivingLicence drivingLicense) throws ResourceNotFoundException {
        var drivingLicenceDb = serviceFinder.findById(drivingLicense.getId());
        if(!drivingLicenceDb.equals(drivingLicense)) {
            throw new ResourceNotFoundException("License introuvable");
        } else {
            drivingLicenceDb.withAvailablePoints(drivingLicense.getAvailablePoints() - point);
            return drivingLicense;
        }
    }
}
