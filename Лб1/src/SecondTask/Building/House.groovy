package SecondTask.Building

class House {
    Basement basement
    Wall wall
    def walls = []
    Window window
    def windows = []
    Door door
    Roof roof

    House(){
        basement = new Basement()
        walls.add(new Wall())
    }
}
