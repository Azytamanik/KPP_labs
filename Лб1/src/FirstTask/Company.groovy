package FirstTask

class Company {
    def employers = [
            new President("Magnus", 5000),
            new Manager("Anatoliy", 4800),
            new Worker("Hikaru", 5100)
    ]

    Company(){
        employers.add(new Worker("Yan", 4500))
    }

    void employersInfo(){
        println("Count of employers: " + employers.size())
        println("Amount of money to pay off " + employers.sum {it -> it.getSalary()})
    }

    void printList(){
        for (Employer e : employers){
            println(e.getId() + e.getName() + e.getSalary())
        }
    }
}
