package FirstTask

class President extends Employer implements PresidentCredentials{

    President(name, baseSalary) {
        super(name, baseSalary)
    }

    @Override
    double calculateSalary(baseSalary) {
        return baseSalary * 12
    }

    @Override
    Employer recruitEmployer() {
        return new Worker("Another Ivan", 5000)
    }

    @Override
    void fireEmployer(Employer employer) {
        employer = null
    }

    @Override
    void changeSalary(Employer employer) {
        employer.setSalary(employer.getSalary() + 10)
    }
}