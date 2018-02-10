package database_crud.ViewAndController;

import database_crud.entities.*;
import database_crud.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View {
    private Map<String, String> menu;
    private Map<String, Printable> menuMethod;
    private BufferedReader input;

    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private ProjectService projectService;
    private WorksOnService worksOnService;
    private MetaDataService metaDataService;

    public View(){
        menu = new HashMap<>();
        menuMethod = new HashMap<>();
        input = new BufferedReader(new InputStreamReader(System.in));

        employeeService = new EmployeeService();
        departmentService = new DepartmentService();
        projectService = new ProjectService();
        worksOnService = new WorksOnService();
        metaDataService = new MetaDataService();

        menu.put("1", "1 - Employee table");
        menu.put("11", "11 - Select all");
        menu.put("12", "12 - Select by id");
        menu.put("13", "13 - Select by firs name");
        menu.put("14", "14 - Select by last name");
        menu.put("15", "15 - Select by department number");
        menu.put("16", "16 - Update table");
        menu.put("17", "17 - Create row");
        menu.put("18", "18 - Delete employee");

        menu.put("2", "2 - Department table");
        menu.put("21", "21 - Select all");
        menu.put("22", "22 - Select by department number");
        menu.put("23", "23 - Select by department name");
        menu.put("24", "24 - Select by location");
        menu.put("25", "25 - Update table");
        menu.put("26", "26 - Create row");
        menu.put("27", "27 - Delete department");

        menu.put("3", "3 - Project table");
        menu.put("31", "31 - Select all");
        menu.put("32", "32 - Select by project number");
        menu.put("33", "33 - Select by project name");
        menu.put("34", "34 - Select by budget");
        menu.put("35", "35 - Update table");
        menu.put("36", "36 - Create row");
        menu.put("37", "37 - Delete project");

        menu.put("4", "4 - Works On table");
        menu.put("41", "41 - Select all");
        menu.put("42", "42 - Select by job");
        menu.put("43", "43 - Select by date");
        menu.put("44", "44 - Update table");
        menu.put("45", "45 - Create row");
        menu.put("46", "46 - Delete works on");

        menu.put("5", "5 - Show data base info");

        menu.put("Q", "Q - for exit");


        menuMethod.put("11", this::employeeSelectAll);
        menuMethod.put("12", this::employeeSelectById);
        menuMethod.put("13", this::employeeSelectByFirstName);
        menuMethod.put("14", this::employeeSelectByLastName);
        menuMethod.put("15", this::employeeSelectByDepartmentNumber);
        menuMethod.put("16", this::employeeUpdate);
        menuMethod.put("17", this::employeeCreate);
        menuMethod.put("18", this::employeeDelete);
        menuMethod.put("21", this::departmentSelectAll);
        menuMethod.put("22", this::departmentSelectByDepartmentNumber);
        menuMethod.put("23", this::departmentSelectByDepartmentName);
        menuMethod.put("24", this::departmentSelectByLocation);
        menuMethod.put("25", this::departmentUpdate);
        menuMethod.put("26", this::departmentCreate);
        menuMethod.put("27", this::departmentDelete);
        menuMethod.put("31", this::projectSelectAll);
        menuMethod.put("32", this::projectSelectBuProjectNumber);
        menuMethod.put("33", this::projectSelectByProjectName);
        menuMethod.put("34", this::projectSelectByBudget);
        menuMethod.put("35", this::projectUpdate);
        menuMethod.put("36", this::projectCreate);
        menuMethod.put("37", this::projectDelete);
        menuMethod.put("41", this::worksOnSelectAll);
        menuMethod.put("42", this::worksOnSelectByJob);
        menuMethod.put("43", this::worksOnSelectByDate);
        menuMethod.put("44", this::worksOnUpdate);
        menuMethod.put("45", this::worksOnCreate);
        menuMethod.put("46", this::worksOnDelete);
        menuMethod.put("5", this::databaseInfo);

    }

    private <T>void showSelectedList(List<T> result){
        for (Object object : result)
            System.out.println(object);
    }

    private void employeeSelectAll() throws SQLException {
        showSelectedList(employeeService.findAll());
    }
    private void employeeSelectById() throws SQLException {
        try {
            System.out.println("Input id of employee");
            System.out.println(employeeService.findById(Integer.parseInt(input.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void employeeSelectByFirstName() throws SQLException {
        try {
            System.out.println("Input first name of employee");
            showSelectedList(employeeService.findByFirstName(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void employeeSelectByLastName() throws SQLException {
        try {
            System.out.println("Input last name of employee");
            showSelectedList(employeeService.findByLastName(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void employeeSelectByDepartmentNumber() throws SQLException {
        try {
            System.out.println("Input department number of employee");
            showSelectedList(employeeService.findByDeptNo(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void employeeUpdate() throws SQLException {
        Employee employee;
        try {
            System.out.println("Select employee id to update");
            employee = employeeService.findById(Integer.parseInt(input.readLine()));
            System.out.println("Input new employee first name");
            employee.setEmp_fname(input.readLine());
            System.out.println("Input new employee last name");
            employee.setEmp_lname(input.readLine());
            System.out.println("Input new employee department number");
            employee.setDept_no(input.readLine());
            System.out.println("Updated " + employeeService.update(employee) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void employeeCreate() throws SQLException {
        Employee employee = new Employee();
        try {
            System.out.println("Input employee number");
            employee.setEmp_no(Integer.parseInt(input.readLine()));
            System.out.println("Input employee first name");
            employee.setEmp_fname(input.readLine());
            System.out.println("Input employee last name");
            employee.setEmp_lname(input.readLine());
            System.out.println("Input employee department number");
            employee.setDept_no(input.readLine());
            System.out.println("Created " + employeeService.create(employee) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void employeeDelete() throws SQLException {
        try {
            System.out.println("Input employee number");
            System.out.println("Deleted " + employeeService.delete(Integer.parseInt(input.readLine())) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void departmentSelectAll() throws SQLException {
        for (Object object : departmentService.findAll())
            System.out.println(object);
    }
    private void departmentSelectByDepartmentNumber() throws SQLException {
        try {
            System.out.println("Input department number");
            System.out.println(departmentService.findById(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void departmentSelectByDepartmentName() throws SQLException {
        try {
            System.out.println("Input department name");
            System.out.println(departmentService.findByDeptName(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void departmentSelectByLocation() throws SQLException {
        try {
            System.out.println("Input department location");
            System.out.println(departmentService.findByLocation(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void departmentUpdate() throws SQLException {
        Department department;
        try {
            System.out.println("Select department number to update");
            department = departmentService.findById(input.readLine());
            System.out.println("Input new department name");
            department.setDept_name(input.readLine());
            System.out.println("Input new department location");
            department.setLocation(input.readLine());
            System.out.println("Updated " + departmentService.update(department) + " row(s)");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void departmentCreate() throws SQLException {
        Department department = new Department();
        try {
            System.out.println("Input department number");
            department.setDept_no(input.readLine());
            System.out.println("Input department name");
            department.setDept_name(input.readLine());
            System.out.println("Input department location");
            department.setLocation(input.readLine());
            System.out.println("Created " + departmentService.create(department) + " row(s)");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void departmentDelete() throws SQLException {
        String old_dept_no;
        String new_dept_no;
        try {
            System.out.println("Transfer employee");
            System.out.println("Input old department number");
            old_dept_no = input.readLine();
            System.out.println("Input new department number");
            new_dept_no = input.readLine();
            for (Employee employee: employeeService.findByDeptNo(old_dept_no)){
                employee.setDept_no(new_dept_no);
                employeeService.update(employee);
            }
            System.out.println("Deleted " + departmentService.delete(old_dept_no) + " row(s)");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void projectSelectAll() throws SQLException {
        for (Object object : projectService.findAll())
            System.out.println(object);
    }
    private void projectSelectBuProjectNumber() throws SQLException {
        try {
            System.out.println("Input project number");
            System.out.println(projectService.findById(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void projectSelectByProjectName() throws SQLException {
        try {
            System.out.println("Input project name");
            System.out.println(projectService.findByProjectName(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void projectSelectByBudget() throws SQLException {
        try {
            System.out.println("Input project budget");
            System.out.println(projectService.findByBudget(Integer.parseInt(input.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void projectUpdate() throws SQLException {
        Project project;
        try{
            System.out.println("Select project number to update");
            project = projectService.findById(input.readLine());
            System.out.println("Input new project name");
            project.setProject_name(input.readLine());
            System.out.println("Input new project budget");
            project.setBudget(Integer.parseInt(input.readLine()));
            System.out.println("Updated " + projectService.update(project) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void projectCreate() throws SQLException {
        Project project = new Project();
        try{
            System.out.println("Input project number");
            project.setProject_no(input.readLine());
            System.out.println("Input project name");
            project.setProject_name(input.readLine());
            System.out.println("Input project budget");
            project.setBudget(Integer.parseInt(input.readLine()));
            System.out.println("Create " + projectService.create(project) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void projectDelete() throws SQLException {
        try{
            System.out.println("Input project number");
            System.out.println("Deleted " + projectService.delete(input.readLine()) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void worksOnSelectAll() throws SQLException {
        for (Object object : worksOnService.findAll())
            System.out.println(object);
    }
    private void worksOnSelectByJob() throws SQLException {
        try {
            System.out.println("Input works on job");
            showSelectedList(worksOnService.findByJob(input.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void worksOnSelectByDate() throws SQLException {
        try {
            System.out.println("Input works on date like (1999-01-23)");
            showSelectedList(worksOnService.findByDate(Date.valueOf(input.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void worksOnUpdate() throws SQLException {
        WorksOn worksOn = new WorksOn();
        try {
            System.out.println("Select employee number to update");
            worksOn.setEmployee(employeeService.findById(Integer.parseInt(input.readLine())));
            System.out.println("Select project number to update");
            worksOn.setProject(projectService.findById(input.readLine()));
            System.out.println("Input new job");
            worksOn.setJob(input.readLine());
            System.out.println("Input new date like (1999-01-23)");
            worksOn.setEnter_date(Date.valueOf(input.readLine()));
            System.out.println("Updated " + worksOnService.update(worksOn) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void worksOnCreate() throws SQLException {
        Employee employee = new Employee();
        Project project = new Project();
        WorksOn worksOn = new WorksOn();
        try {
            System.out.println("Select 1 - to new employee or 2 - for old employee");
            if(input.readLine().equals("1")){
                System.out.println("Input employee id");
                employee.setEmp_no(Integer.parseInt(input.readLine()));
                System.out.println("Input employee first name");
                employee.setEmp_fname(input.readLine());
                System.out.println("Input employee last name");
                employee.setEmp_lname(input.readLine());
                System.out.println("Input employee department number");
                employee.setDept_no(input.readLine());
            }else if (input.readLine().equals("2")){
                System.out.println("Select employee id");
                employee = employeeService.findById(Integer.parseInt(input.readLine()));
            }

            System.out.println("Select 1 - to new project or 2 - for old project");
            if(input.readLine().equals("1")){
                System.out.println("Input project number");
                project.setProject_no(input.readLine());
                System.out.println("Input project name");
                project.setProject_name(input.readLine());
                System.out.println("Input project budget");
                project.setBudget(Integer.parseInt(input.readLine()));
            }else if (input.readLine().equals("2")){
                System.out.println("Select project number");
                project = projectService.findById(input.readLine());
            }
            System.out.println("Input works on job");
            worksOn.setJob(input.readLine());
            System.out.println("Input works on date like (1999-01-23)");
            worksOn.setEnter_date(Date.valueOf(input.readLine()));
            worksOn.setEmployee(employee);
            worksOn.setProject(project);
            System.out.println("Create " + worksOnService.create(worksOn) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void worksOnDelete() throws SQLException {
        CompositeKey key = new CompositeKey();
        try{
            System.out.println("Input employee id");
            key.setEmp_no(Integer.parseInt(input.readLine()));
            System.out.println("Input project number");
            key.setProject_no(input.readLine());
            System.out.println("Deleted " + worksOnService.delete(key) + " row(s)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void databaseInfo() throws SQLException{
        showSelectedList(metaDataService.getTableMetaData());
    }

    private void showTableList(){
        for (String key : menu.keySet()){
            if(key.length() == 1)
                System.out.println(menu.get(key));
        }
    }

    private void showTableMenu(String table){
        for (String key : menu.keySet()){
            if(key.length() != 1 && key.substring(0, 1).equals(table))
                System.out.println(menu.get(key));
        }
    }

    public void show(){
        String keyMenu = "";
        do {
            try {
                showTableList();
                keyMenu = input.readLine().toUpperCase();
                if(keyMenu.matches("[1-4]")) {
                    showTableMenu(keyMenu);
                    keyMenu = input.readLine();
                    menuMethod.get(keyMenu).print();
                }else if(keyMenu.equals("5")){
                    menuMethod.get(keyMenu).print();
                }

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }while (!keyMenu.equals("Q"));
    }

}
