package guru.springframework.domain;

import guru.springframework.reposirories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureTestIT {

    @Autowired
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription(){
        Optional<UnitOfMeasure> unitOfMeasure = repository.findByUom("Cup");
        assertEquals(unitOfMeasure.get().getUom(), "Cup");
    }


    @Test
    public void findByDescriptionOunce(){
        Optional<UnitOfMeasure> unitOfMeasure = repository.findByUom("Ounce");
        assertEquals(unitOfMeasure.get().getUom(), "Ounce");
    }
}