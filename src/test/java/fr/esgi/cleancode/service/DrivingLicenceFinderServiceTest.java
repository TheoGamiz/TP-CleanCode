package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.NotExtensible;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DrivingLicenceFinderServiceTest {

    @InjectMocks
    private DrivingLicenceFinderService service;

    @Mock
    private InMemoryDatabase database;

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "lorem ipsuil",
            "dkjsfqlshjfbqklb",
            "087986087608760",
            "98Y9HIBFDSKJF9SEH"
    })
    void should_find(String validSSNumber) {
        val actual = validate(DrivingLicenceFinderService.findDrivingLicenceById(validSSNumber));
        assertThat(actual).containsValidINstanceOf(DrivingLicence.class);
    }

    @Test
    void should_not_find() {

    }
}