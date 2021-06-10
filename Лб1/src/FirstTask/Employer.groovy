package FirstTask

abstract class Employer implements Employers{
    static def memoryId = 0
    def id
    final def name
    def salary

    Employer(name, baseSalary){
        id = ++memoryId
        this.name = name
        this.salary = calculateSalary(baseSalary)
    }

    abstract double calculateSalary(baseSalary)
}
