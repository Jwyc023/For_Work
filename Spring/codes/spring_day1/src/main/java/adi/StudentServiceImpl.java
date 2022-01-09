package adi;

/**
 * 用来测试自动注入
 */
public class StudentServiceImpl implements StudentService {

    //自动注入
    private StudentDAO studentNewDAO;

    public void setStudentNewDAO(StudentDAO studentNewDAO) {
        this.studentNewDAO = studentNewDAO;
    }

    @Override
    public void save(String name) {
        System.out.println("Service Name: "+name);
        studentNewDAO.save(name);
    }
}
