package SecondTask.Building

class Wall implements IPart{
    @Override
    def build() {
        return new Wall()
    }
}
