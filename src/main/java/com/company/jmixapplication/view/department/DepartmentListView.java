package com.company.jmixapplication.view.department;

import com.company.jmixapplication.entity.Department;
import com.company.jmixapplication.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "departments", layout = MainView.class)
@ViewController(id = "Department.list")
@ViewDescriptor(path = "department-list-view.xml")
@LookupComponent("departmentsDataGrid")
@DialogMode(width = "64em")
public class DepartmentListView extends StandardListView<Department> {
}