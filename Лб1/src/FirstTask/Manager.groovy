package FirstTask

class Manager extends Employer{

    Manager(name, baseSalary) {
        super(name, baseSalary)
    }

    @Override
    double calculateSalary(baseSalary) {
        return baseSalary * 5
    }
}
