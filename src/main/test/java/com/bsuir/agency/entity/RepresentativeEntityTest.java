package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class RepresentativeEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setRepresentativeId_minusId_throwsException(){
        RepresentativeinfoEntity representativeEntity = new RepresentativeinfoEntity();
        representativeEntity.setRepresentativeId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRepresentativeUserId_minusId_throwsException(){
        RepresentativeinfoEntity representativeEntity = new RepresentativeinfoEntity();
        representativeEntity.setRepresentativeUserId(-1);
    }


}