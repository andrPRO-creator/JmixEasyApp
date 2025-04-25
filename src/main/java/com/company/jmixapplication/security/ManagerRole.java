package com.company.jmixapplication.security;

import com.company.jmixapplication.entity.Department;
import com.company.jmixapplication.entity.Employee;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Manager", code = ManagerRole.CODE)
public interface ManagerRole {
    String CODE = "manager";

    @MenuPolicy(menuIds = {"Employee.list", "Department.list"})
    @ViewPolicy(viewIds = {"Employee.list", "Department.list"})
    void screens();

    @EntityAttributePolicy(entityClass = Department.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Department.class, actions = EntityPolicyAction.READ)
    void department();

    @EntityAttributePolicy(entityClass = Employee.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Employee.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void employee();
}