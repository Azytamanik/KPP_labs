package SecondTask.Workers

import SecondTask.Building.Basement
import SecondTask.Building.Door
import SecondTask.Building.House
import SecondTask.Building.Roof
import SecondTask.Building.Wall
import SecondTask.Building.Window

import java.lang.reflect.Field

class Worker implements IWorker{

    @Override
    def checkBuilded(House house) {
        def dummy

        //basement
        if (house.getBasement() == null){
            dummy = new Basement()
            house.setBasement(dummy.build())
            println("done basement")
        }
        //walls
        dummy = new Wall()
        for (int x = 0; x < 4; x++){
            if (house.walls[x] == null){
                house.walls[x] = dummy.build()
                println("done wall " + (x + 1))
            }
        }
        //windows
        dummy = new Window()
        for (int x = 0; x < 4; x++){
            if (house.windows[x] == null){
                house.windows[x] = dummy.build()
                println("done windows " + (x + 1))
            }
        }
        //door
        if (house.getDoor() == null){
            dummy = new Door()
            house.setDoor(dummy.build())
            println("done door")
        }
        //roof
        if (house.getRoof() == null){
            dummy = new Roof()
            house.setRoof(dummy.build())
            println("done roof")
        }
    }
}
