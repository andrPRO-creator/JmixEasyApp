package com.company.jmixapplication.view.employee;

import com.company.jmixapplication.entity.Employee;
import com.company.jmixapplication.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "employees/:id", layout = MainView.class)
@ViewController(id = "Employee.detail")
@ViewDescriptor(path = "employee-detail-view.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeDetailView extends StandardDetailView<Employee> {
}