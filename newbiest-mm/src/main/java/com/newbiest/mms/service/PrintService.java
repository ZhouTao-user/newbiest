package com.newbiest.mms.service;

import com.newbiest.base.exception.ClientException;
import com.newbiest.mms.model.MaterialLot;

/**
 * @author guoxunbo
 * @date 4/6/21 3:04 PM
 */
public interface PrintService {
    void printMLot(MaterialLot materialLot) throws ClientException;

    void printBoxMLot(String materialLotId) throws ClientException;

}
