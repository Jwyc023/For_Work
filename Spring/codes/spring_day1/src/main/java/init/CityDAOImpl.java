package init;

public class CityDAOImpl implements CityDAO {

    @Override
    public void delete(String id) {
        System.out.println("删除的id = " + id);
    }
}
