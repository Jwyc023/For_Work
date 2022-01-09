package adi;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void save(String name) {
        System.out.println("DAO name: "+name);
    }
}
