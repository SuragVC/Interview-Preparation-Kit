import java.beans.Transient;
import java.io.*;

class SerilizationExample {
    public static void main(String[] args) throws IOException {
        EmployeeExample employee = new EmployeeExample(1,"Kiran",200);
        FileOutputStream fileOutputStream = new FileOutputStream("SerilizedFile.ser");
        ObjectOutputStream objectStream = new ObjectOutputStream(fileOutputStream);
        objectStream.writeObject(employee);
        System.out.println("File Serialized Successfully");
    }
}
class DeSerilizationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream ("SerilizedFile.ser");
        ObjectInputStream objectStream = new ObjectInputStream(fileInputStream);
        EmployeeExample employee = (EmployeeExample) objectStream.readObject();
        System.out.println(employee.toString());
        System.out.println("File de serialized successfully");
    }
}
class EmployeeExample implements Serializable{
    private Integer id;
    private String name;
    private transient Integer reporterID;
    /* Because of the transient keyword this variable will not be part
    of serialization, So in the output it will show null.
     */

    public EmployeeExample(Integer id, String name, Integer reporterID) {
        this.id = id;
        this.name = name;
        this.reporterID = reporterID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getReporterID() {
        return reporterID;
    }

    @Override
    public String toString() {
        return "EmployeeExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reporterID=" + reporterID +
                '}';
    }
}