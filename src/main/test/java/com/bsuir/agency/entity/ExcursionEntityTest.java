package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 12.05.2017.
 */
public class ExcursionEntityTest {

    @Test(expected = IllegalArgumentException.class)
    public void setExcursionId_minusId_throwsIllegalArgumentException(){
        ExcursionEntity excursionEntity = new ExcursionEntity();
        excursionEntity.setExcursionId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setExcursionId_minusRepresentativeId_noException_throwsIllegalArgumentException(){
        ExcursionEntity excursionEntity = new ExcursionEntity();
        excursionEntity.setRepresentativeId(-1);
    }
}