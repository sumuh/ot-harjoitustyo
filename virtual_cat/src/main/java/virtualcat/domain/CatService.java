/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcat.domain;

import virtualcat.dao.CatDao;

/**
 *
 * @author Susanna Muhli
 */
public class CatService {
    
    //this class manages stats
    
    private CatDao catDao;
    
    public CatService(CatDao catDao) {
        this.catDao = catDao;
    }
    
}
