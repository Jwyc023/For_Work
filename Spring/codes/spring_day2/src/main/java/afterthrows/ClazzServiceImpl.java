package afterthrows;

public class ClazzServiceImpl implements ClazzService {
    @Override
    public void save(String name) {
        System.out.println("Service save调用"+name);
    }

    @Override
    public String find(String name) {
        System.out.println("Service find调用"+name);
        throw  new RuntimeException("find方法调用出错啦!");
    }
}
