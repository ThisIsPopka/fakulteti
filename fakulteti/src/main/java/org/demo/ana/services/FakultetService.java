package org.demo.ana.services;
 
import java.util.List;
 
import org.demo.ana.entity.Fakulteti;
import org.demo.ana.dao.FakultetDao;
 
public class FakultetService {
 
    private static FakultetDao fakultetDao;
 
    public FakultetService() {
    	fakultetDao = new FakultetDao();
    }
 
    public void persist(Fakulteti entity) {
    	fakultetDao.openCurrentSessionwithTransaction();
    	fakultetDao.persist(entity);
    	fakultetDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Fakulteti entity) {
    	fakultetDao.openCurrentSessionwithTransaction();
    	fakultetDao.update(entity);
    	fakultetDao.closeCurrentSessionwithTransaction();
    }
 
    public Fakulteti findById(String id) {
    	fakultetDao.openCurrentSession();
    	Fakulteti fakultet = fakultetDao.findById(id);
    	fakultetDao.closeCurrentSession();
        return fakultet;
    }
 
    public void delete(String id) {
    	fakultetDao.openCurrentSessionwithTransaction();
    	Fakulteti fakultet = fakultetDao.findById(id);
    	fakultetDao.delete(fakultet);
    	fakultetDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Fakulteti> findAll() {
    	fakultetDao.openCurrentSession();
        List<Fakulteti> fakulteti = fakultetDao.findAll();
        fakultetDao.closeCurrentSession();
        return fakulteti;
    }
 
    public void deleteAll() {
    	fakultetDao.openCurrentSessionwithTransaction();
    	fakultetDao.deleteAll();
    	fakultetDao.closeCurrentSessionwithTransaction();
    }
 
    public FakultetDao fakultetDao() {
        return fakultetDao;
    }
}
