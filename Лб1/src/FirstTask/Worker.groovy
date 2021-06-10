package FirstTask

class Worker extends Employer{

    Worker(name, baseSalary) {
        super(name, baseSalary)
    }

    @Override
    double calculateSalary(baseSalary) {
        return baseSalary * 2
    }
}
