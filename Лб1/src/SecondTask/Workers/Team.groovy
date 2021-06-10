package SecondTask.Workers

import SecondTask.Building.House

class Team {

    def leader = new TeamLeader()
    Worker[] workers = [
            new Worker(),
            new Worker(),
            new Worker()
    ]

    Team(){
        House house = new House()
        println(leader.checkBuilded(house))
        workers[0].checkBuilded(house)
        println(leader.checkBuilded(house))
    }
}
