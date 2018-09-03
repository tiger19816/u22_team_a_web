package hal.u22.works.team.a.web.tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CleanImageUploadDao extends Dao {

    public CleanImageUploadDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public List<String[]> getSupplierList() throws SQLException, ClassNotFoundException {

        List<String[]> supplierList = new ArrayList<String[]>();

        String supplierSQL = "";
        supplierSQL = "SELECT no, name ";
        supplierSQL += "FROM supplier";

        this.read(supplierSQL);

        while (this.rs.next()) {
            String[] supplier = new String[2];
            supplier[0] = this.rs.getString("no");
            supplier[1] = this.rs.getString("name");
            System.out.println(supplier[0] + ":" + supplier[1]);
            supplierList.add(supplier);
        }
        return supplierList;
    }

    public List<String[]> getProjectsList() throws SQLException, ClassNotFoundException {

        List<String[]> projectList = new ArrayList<String[]>();

        String projectSQL = "";
        projectSQL = "SELECT projects.no, posts.title ";
        projectSQL += "FROM projects ";
        projectSQL += "INNER JOIN posts ON post_no = posts.no";

        this.read(projectSQL);

        while (this.rs.next()) {
            String[] project = new String[2];
            project[0] = this.rs.getString("projects.no");
            project[1] = this.rs.getString("posts.title");
            projectList.add(project);
        }

        return projectList;
    }

    public void updateData(String supplierNo, String projectNo, String fileName)
            throws SQLException, ClassNotFoundException {

        String sql;
        sql = "INSERT INTO cleanings(supplier_no, project_no, photo, complete_flag) ";
        sql += "VALUES(" + supplierNo + ", " + projectNo + ", '" + fileName + "', 1)";
        upgrade(sql);
    }
}
