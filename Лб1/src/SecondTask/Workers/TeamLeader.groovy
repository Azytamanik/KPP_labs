package SecondTask.Workers

import SecondTask.Building.House
import SecondTask.Building.Wall
import SecondTask.Building.Window

class TeamLeader implements IWorker{

    @Override
    def checkBuilded(House house) {
        int increment = 0
        String builded = "There have been already built "
        //check basement
        builded += (house.getBasement() != null) ?  "basement" : ""
        //check walls
        for (Wall w : house.walls){
            if (w != null){
                increment++
            }
        }
        if (increment != 0){
            builded += (increment > 1 && increment != 0) ? ", " + increment + " walls" : ", " + increment + " wall"
            increment = 0
        }
        //check window
        for (Window w : house.windows){
            if (w != null){
                increment++
            }
        }
        if (increment != 0){
            builded += (increment > 1 && increment != 0) ? ", " + increment + " windows" : ", " + increment + " window"
            increment = 0
        }
        //check door
        builded += (house.getDoor() != null) ?  ", door" : ""
        //check roof
        builded += (house.getRoof() != null) ?  " and roof." : ""

        return builded
    }
}
