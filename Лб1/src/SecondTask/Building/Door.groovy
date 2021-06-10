package SecondTask.Building

class Door implements IPart{
    @Override
    def build() {
        return new Door()
    }
}
