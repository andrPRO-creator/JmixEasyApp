package com.company.jmixapplication.view.employee;

import com.company.jmixapplication.entity.Employee;
import com.company.jmixapplication.view.main.MainView;
import com.google.common.base.Strings;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;


@Route(value = "employees", layout = MainView.class)
@ViewController(id = "Employee.list")
@ViewDescriptor(path = "employee-list-view.xml")
@LookupComponent("employeesDataGrid")
@DialogMode(width = "64em")
public class EmployeeListView extends StandardListView<Employee> {

    @ViewComponent
    private TypedTextField<String> inputDepartment;

    @ViewComponent
    private CollectionLoader<Employee> employeesDl;
    @Subscribe("inputDepartment")
    public void onInputDepartmentComponentValueChange(final AbstractField.ComponentValueChangeEvent<TypedTextField<String>, String> event) {
        String departmentName = event.getValue();
        employeesDl.setQuery("select e from Employee e where (:departmentName is null or lower(e.department.name) like lower(:departmentName))");

        if (Strings.isNullOrEmpty(departmentName)) {
            employeesDl.setParameter("departmentName", null);
        } else {
            employeesDl.setParameter("departmentName", "%" + departmentName + "%");
        }

        employeesDl.load();
    }
}