package utils;

import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class ServiceFactory {
    public static CustomerService getCustomerService(){
        return new ServiceProxyHandler<CustomerService>().createProxyService(new CustomerServiceImpl());
    }
    public static EmployeeService getEmployeeService(){
        return  new ServiceProxyHandler<EmployeeService>().createProxyService(new EmployeeServiceImpl());
    }
}
